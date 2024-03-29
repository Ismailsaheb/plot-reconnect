package com.plot.socialnetwork.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plot.socialnetwork.domain.Person;
import com.plot.socialnetwork.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

	private final PasswordEncoder passwordEncoder;
	private final PersonRepository personRepository;

	@Transactional(readOnly = true)
	public Person findById(Long id) {
		return this.personRepository.findById(id).get();
	}

	@Transactional(readOnly = true)
	public Person findByEmail(String email) {
		return this.personRepository.findByEmail(email);
	}

	@Transactional(readOnly = true)
	public Page<Person> getPeople(String searchTerm, Pageable pageRequest) {
		return this.personRepository.findPeople(searchTerm, pageRequest);
	}

	@Transactional(readOnly = true)
	public Page<Person> getFriends(Person person, String searchTerm, Pageable pageRequest) {
		return this.personRepository.findFriends(person, searchTerm, pageRequest);
	}

	@Transactional(readOnly = true)
	public Page<Person> getFriendOf(Person person, String searchTerm, Pageable pageRequest) {
		return this.personRepository.findFriendOf(person, searchTerm, pageRequest);
	}

	@Transactional
	public void addFriend(Person person, Person friend) {
		if (!person.hasFriend(friend)) {
			person.addFriend(friend);
		}
	}

	@Transactional
	public void removeFriend(Person person, Person friend) {
		if (person.hasFriend(friend)) {
			person.removeFriend(friend);
		}
	}

	@Transactional
	public void update(Person person) {
		this.personRepository.save(person);
	}

	@Transactional
	public Person create(String firstName, String lastName, String email, String password) {
		final Person person = Person.builder().firstName(firstName).lastName(lastName).email(email)
				.password(this.passwordEncoder.encode(password)).build();

		return this.personRepository.save(person);
	}

	public boolean hasValidPassword(Person person, String pwd) {
		return this.passwordEncoder.matches(pwd, person.getPassword());
	}

	public void changePassword(Person person, String pwd) {
		person.setPassword(this.passwordEncoder.encode(pwd));
		this.personRepository.save(person);
	}

}
