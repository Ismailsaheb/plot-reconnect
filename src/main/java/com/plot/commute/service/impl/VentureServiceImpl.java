package com.plot.commute.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plot.commute.dto.VentureDTO;
import com.plot.commute.entity.Venture;
import com.plot.commute.entity.VillageLkp;
import com.plot.commute.mapper.VentureDTOMapper;
import com.plot.commute.repository.JpaRepository.VentureRepository;
import com.plot.commute.service.VentureService;
import com.plot.socialnetwork.domain.Person;

@Service
@Transactional
public class VentureServiceImpl implements VentureService {

	@Autowired
	private VentureRepository ventureRepository;

	@Autowired
	private VentureDTOMapper ventureDTOMapper;

	@Override
	public Page<VentureDTO> getAllUserVentures(Person profile, String searchTerm, Pageable pageRequest) {
		Page<Venture> page = this.ventureRepository.searchUserVentures(profile, searchTerm, pageRequest);
		return page.<VentureDTO>map(this.ventureDTOMapper::map);
	}

	@Override
	public Page<VentureDTO> searchAllVentures(String searchTerm, Pageable pageRequest) {
		Page<Venture> page = this.ventureRepository.searchAllVentures(searchTerm, pageRequest);
		return page.<VentureDTO>map(this.ventureDTOMapper::map);
	}

	@Override
	public Page<VentureDTO> searchByVillage(Long villageLkpId, String searchTerm, Pageable pageRequest) {
		VillageLkp villageLkp = new VillageLkp();
		villageLkp.setId(villageLkpId);
		Page<Venture> page = this.ventureRepository.searchByVillage(villageLkp, searchTerm, pageRequest);
		return page.<VentureDTO>map(this.ventureDTOMapper::map);
	}

	@Override
	public void save(VentureDTO ventureDTO) {
		this.ventureRepository.save(this.ventureDTOMapper.map(ventureDTO));
	}

	@Override
	public void delete(Long ventureId) {
		this.ventureRepository.deleteById(ventureId);
	}
}
