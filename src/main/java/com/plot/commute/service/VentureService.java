package com.plot.commute.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.plot.commute.dto.VentureDTO;
import com.plot.socialnetwork.domain.Person;

public interface VentureService {

	Page<VentureDTO> getAllUserVentures(Person profile, String searchTerm, Pageable pageRequest);

	Page<VentureDTO> searchAllVentures(String searchTerm, Pageable pageRequest);

	void delete(Long ventureId);

	void save(VentureDTO ventureDTO);

	Page<VentureDTO> searchByVillage(Long villageLkpId, String searchTerm, Pageable pageRequest);

}
