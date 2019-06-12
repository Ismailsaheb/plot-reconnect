package com.plot.commute.service;

import java.util.List;

import com.plot.commute.dto.LandDetailDTO;

public interface LandDetailService {

	List<LandDetailDTO> findAll();

	List<LandDetailDTO> findLandsByVentureId(Long ventureId);

	void save(LandDetailDTO landDetailDTO);

	void delete(Long landDetailDTOId);

}
