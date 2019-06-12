package com.plot.commute.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plot.commute.dto.LandDetailDTO;
import com.plot.commute.service.LandDetailService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/land")
@Slf4j
public class LandController {

	@Autowired
	private LandDetailService landDetailService;

	@GetMapping("/all")
	public ResponseEntity<List<LandDetailDTO>> findAll() {
		log.debug("success---------------->");
		return ResponseEntity.ok(this.landDetailService.findAll());
	}

	@GetMapping("/venture/{ventureId}")
	public ResponseEntity<List<LandDetailDTO>> findLandsByVentureId(@PathParam("ventureId") Long ventureId) {
		log.debug("success---------------->");
		return ResponseEntity.ok(this.landDetailService.findLandsByVentureId(ventureId));
	}

	@ApiOperation(value = "Save or update Land Details")
	@PostMapping
	public void save(@RequestBody LandDetailDTO landDetailDTO) {
		this.landDetailService.save(landDetailDTO);
	}

	@ApiOperation(value = "Delete Land Details")
	@DeleteMapping("{landId}")
	public void delete(@PathParam("landId") Long landId) {
		this.landDetailService.delete(landId);
	}
}
