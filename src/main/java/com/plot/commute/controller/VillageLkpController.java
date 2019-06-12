package com.plot.commute.controller;

import static com.plot.socialnetwork.config.Constants.URI_API_PREFIX;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plot.commute.entity.VillageLkp;
import com.plot.commute.service.impl.VillageLkpServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(tags = "VillageLkp")
@RestController
@RequestMapping(value = URI_API_PREFIX + "/villageLkp")
@Slf4j
public class VillageLkpController {
	@Autowired
	private VillageLkpServiceImpl villageLkpServiceImpl;

	@ApiOperation(value = "Find all Ventures")
	@GetMapping("/venture/all")
	public List<VillageLkp> findAll() {
		final List<VillageLkp> villageLkp = this.villageLkpServiceImpl.findAll();
		return villageLkp;
	}

	@ApiOperation(value = "Save or update VillageLkp")
	@PostMapping
	public void save(@RequestBody VillageLkp villageLkp) {
		this.villageLkpServiceImpl.save(villageLkp);
	}

	@ApiOperation(value = "Delete VillageLkp")
	@DeleteMapping("{villageLkpId}")
	public void delete(@PathParam("villageLkpId") Long villageLkpId) {
		this.villageLkpServiceImpl.delete(villageLkpId);
	}
}
