package com.plot.commute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plot.commute.dto.SarveyDetailDTO;
import com.plot.commute.entity.SarveyDetail;
import com.plot.commute.entity.Venture;
import com.plot.commute.mapper.SarveyDTOMapper;
import com.plot.commute.repository.JpaRepository.SarveyRepository;
import com.plot.commute.service.SarveyService;

@Service
@Transactional
public class SarveyServiceImpl implements SarveyService {

	@Autowired
	private SarveyRepository sarveyRepository;

	@Autowired
	private SarveyDTOMapper sarveyDTOMapper;

	@Override
	public List<SarveyDetailDTO> findAll() {
		List<SarveyDetail> sarveyDetailList = this.sarveyRepository.findAll();
		return this.sarveyDTOMapper.mapList(sarveyDetailList);
	}

	@Override
	public List<SarveyDetailDTO> findSarvaysByVentureId(Long ventureId) {
		Venture venture = new Venture();
		venture.setId(ventureId);
		List<SarveyDetail> findSarvaysByVentureId = this.sarveyRepository.findSarvaysByVenture(venture);
		return this.sarveyDTOMapper.mapList(findSarvaysByVentureId);
	}

	@Override
	public void save(SarveyDetailDTO sarveyDetailDTO) {
		this.sarveyRepository.save(this.sarveyDTOMapper.map(sarveyDetailDTO));

	}

	@Override
	public void delete(Long landId) {
		this.sarveyRepository.deleteById(landId);

	}
}
