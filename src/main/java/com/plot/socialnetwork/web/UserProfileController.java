package com.plot.socialnetwork.web;

import static com.plot.socialnetwork.config.Constants.ERROR_PASSWORD_CONFIRMATION;
import static com.plot.socialnetwork.config.Constants.ERROR_SIGN_UP_EMAIL;
import static com.plot.socialnetwork.config.Constants.ERROR_UPDATE_EMAIL;
import static com.plot.socialnetwork.config.Constants.ERROR_UPDATE_PROFILE;
import static com.plot.socialnetwork.config.Constants.URI_API_PREFIX;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plot.socialnetwork.domain.Person;
import com.plot.socialnetwork.model.ChangePassword;
import com.plot.socialnetwork.model.ContactInformation;
import com.plot.socialnetwork.model.PersonView;
import com.plot.socialnetwork.model.SignUp;
import com.plot.socialnetwork.security.CurrentProfile;
import com.plot.socialnetwork.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "Profile", description = "User settings")
@RestController
@RequestMapping(value = URI_API_PREFIX, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserProfileController {

	private static final Logger log = LoggerFactory.getLogger(UserProfileController.class);

	private final PersonService personService;

	@ApiOperation(value = "Sign-In")
	@GetMapping("/login")
	public ResponseEntity<PersonView> login(@ApiIgnore @CurrentProfile Person profile) {
		log.debug("REST request to get current profile: {}", profile);

		if (null == profile) {
			log.warn("Attempt getting unauthorised profile information failed");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		return ResponseEntity.ok(new PersonView(profile));
	}

	@ApiOperation(value = "Sign-Up")
	@PostMapping("/signUp")
	public ResponseEntity<String> signUp(@Valid @RequestBody SignUp person) throws URISyntaxException {
		log.debug("REST request to sign up a new profile: {}", person);

		final Person result = this.personService.findByEmail(person.getUserName());
		if (null != result) {
			log.debug("Attempt sign up email: {} failed! E-mail is already used by another contact: {}",
					person.getUserName(), result);

			return ResponseEntity.badRequest().contentType(MediaType.TEXT_PLAIN).body(ERROR_SIGN_UP_EMAIL);
		}

		final Person profile = this.personService.create(person.getFirstName(), person.getLastName(),
				person.getUserName(), person.getPassword());

		return ResponseEntity.created(new URI(URI_API_PREFIX + "/person/" + profile.getId())).build();
	}

	@ApiOperation(value = "Change contact information")
	@PutMapping("/updateContact")
	public ResponseEntity<String> updatePerson(@ApiIgnore @CurrentProfile Person profile,
			@Valid @RequestBody ContactInformation contact) {
		log.debug("REST request to update current profile: {} contact information", profile);

		if (!profile.getId().equals(contact.getId())) {
			log.error("Updating profile: {} doesn't match the current one: {}", contact, profile);

			return ResponseEntity.badRequest().contentType(MediaType.TEXT_PLAIN).body(ERROR_UPDATE_PROFILE);
		}

		final String oldEmail = profile.getEmail();
		final String newEmail = contact.getEmail();
		if (!oldEmail.equals(newEmail)) {
			final Person result = this.personService.findByEmail(newEmail);
			if (null != result) {
				log.debug("Attempt to change email value from: {} to  {} failed! "
						+ "E-mail is already used by another contact : {}", result);

				return ResponseEntity.badRequest().contentType(MediaType.TEXT_PLAIN).body(ERROR_UPDATE_EMAIL);
			}
		}

		profile.setFirstName(contact.getFirstName());
		profile.setLastName(contact.getLastName());
		profile.setEmail(contact.getEmail());
		profile.setPhone(contact.getPhone());
		profile.setBirthDate(contact.getBirthDate());
		profile.setGender(contact.getGender());
		this.personService.update(profile);

		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Change password")
	@PostMapping("/changePassword")
	public ResponseEntity<?> changePassword(@ApiIgnore @CurrentProfile Person profile,
			@Valid @RequestBody ChangePassword pwd) throws URISyntaxException {
		log.debug("REST request to change pwd: {}", pwd);

		if (null == profile) {
			log.warn("Attempt to change unauthorised profile password failed");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		final String currentPwd = pwd.getCurrentPassword();
		final String newPwd = pwd.getPassword();
		if (!this.personService.hasValidPassword(profile, currentPwd)) {
			log.warn("Current password: {} doesn't match profile's one: {}", currentPwd, profile);
			return ResponseEntity.badRequest().contentType(MediaType.TEXT_PLAIN).body(ERROR_PASSWORD_CONFIRMATION);
		}

		this.personService.changePassword(profile, newPwd);

		return ResponseEntity.ok().build();
	}

}
