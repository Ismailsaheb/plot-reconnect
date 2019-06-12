package com.plot.commute.service;

import java.util.List;

import com.plot.commute.dto.SarveyDetailDTO;

public interface SarveyService {

	List<SarveyDetailDTO> findAll();

	List<SarveyDetailDTO> findSarvaysByVentureId(Long ventureId);

	void save(SarveyDetailDTO sarveyDetailDTO);

	void delete(Long landId);

}
