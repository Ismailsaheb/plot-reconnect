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

import com.plot.commute.dto.SarveyDetailDTO;
import com.plot.commute.service.SarveyService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/sarvay")
@Slf4j
public class SarvayController {

	@Autowired
	private SarveyService sarveyService;

	@GetMapping("/all")
	public ResponseEntity<List<SarveyDetailDTO>> findAll() {
		log.debug("success---------------->");
		return ResponseEntity.ok(this.sarveyService.findAll());
	}

	@GetMapping("/venture/{ventureId}")
	public ResponseEntity<List<SarveyDetailDTO>> findLandsByVentureId(@PathParam("ventureId") Long ventureId) {
		log.debug("success---------------->");
		return ResponseEntity.ok(this.sarveyService.findSarvaysByVentureId(ventureId));
	}

	@ApiOperation(value = "Save or update Land Details")
	@PostMapping
	public void save(@RequestBody SarveyDetailDTO sarveyDetailDTO) {
		this.sarveyService.save(sarveyDetailDTO);
	}

	@ApiOperation(value = "Delete Land Details")
	@DeleteMapping("{landId}")
	public void delete(@PathParam("landId") Long landId) {
		this.sarveyService.delete(landId);
	}
}
