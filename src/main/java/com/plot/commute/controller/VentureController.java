package com.plot.commute.controller;

import static com.plot.socialnetwork.config.Constants.URI_API_PREFIX;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plot.commute.dto.VentureDTO;
import com.plot.commute.service.VentureService;
import com.plot.socialnetwork.domain.Person;
import com.plot.socialnetwork.security.CurrentProfile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "Venture")
@RestController
@RequestMapping(value = URI_API_PREFIX + "/venture")
@Slf4j
public class VentureController {

	@Autowired
	private VentureService ventureService;

	@ApiOperation(value = "Find User's all Ventures")
	@GetMapping("/user/selectedVentures")
	public Page<VentureDTO> getAllUserVentures(@ApiIgnore @CurrentProfile Person profile,
			@RequestParam(name = "searchTerm", defaultValue = "", required = false) String searchTerm,
			@PageableDefault(size = 20) Pageable pageRequest) {
		log.debug("REST request to get person's: {} Ventures list (searchTerm:{}, pageRequest:{})", profile, searchTerm,
				pageRequest);

		final Page<VentureDTO> ventures = this.ventureService.getAllUserVentures(profile, searchTerm, pageRequest);

		return ventures;
	}

	@ApiOperation(value = "Find all Ventures")
	@GetMapping("/venture/all")
	public Page<VentureDTO> getAllUserVentures(
			@RequestParam(name = "searchTerm", defaultValue = "", required = false) String searchTerm,
			@PageableDefault(size = 20) Pageable pageRequest) {
		log.debug("REST request to get all Ventures list (searchTerm:{}, pageRequest:{})", searchTerm, pageRequest);

		final Page<VentureDTO> ventures = this.ventureService.searchAllVentures(searchTerm, pageRequest);

		return ventures;
	}

	@ApiOperation(value = "Find Ventures by villageLkpId")
	@GetMapping("village/{villageLkpId}")
	public Page<VentureDTO> getAllUserVentures(@PathParam("villageLkpId") Long villageLkpId,
			@RequestParam(name = "searchTerm", defaultValue = "", required = false) String searchTerm,
			@PageableDefault(size = 20) Pageable pageRequest) {
		log.debug("REST request to get all Ventures list (searchTerm:{}, pageRequest:{})", searchTerm, pageRequest);

		final Page<VentureDTO> ventures = this.ventureService.searchByVillage(villageLkpId, searchTerm, pageRequest);

		return ventures;
	}

	@ApiOperation(value = "Save or update Venture")
	@PostMapping
	public void save(@RequestBody VentureDTO ventureDTO) {
		this.ventureService.save(ventureDTO);
	}

	@ApiOperation(value = "Delete Venture")
	@DeleteMapping("{ventureId}")
	public void delete(@PathParam("ventureId") Long ventureId) {
		this.ventureService.delete(ventureId);
	}
}
