package com.plot.commute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plot.commute.dto.LandDetailDTO;
import com.plot.commute.entity.LandDetail;
import com.plot.commute.mapper.LandDetailDTOMapper;
import com.plot.commute.repository.JpaRepository.LandRepository;
import com.plot.commute.repository.dao.LandDao;
import com.plot.commute.service.LandDetailService;

@Service
@Transactional
public class LandDetailServiceImpl implements LandDetailService {

	@Autowired
	private LandRepository landRepository;

	@Autowired
	private LandDao landDao;

	@Autowired
	private LandDetailDTOMapper landDTOMapper;

	@Override
	public List<LandDetailDTO> findAll() {
		List<LandDetail> findAll = this.landRepository.findAll();
		return this.landDTOMapper.mapList(findAll);
	}

	@Override
	public List<LandDetailDTO> findLandsByVentureId(Long ventureId) {
		List<LandDetail> findLandsByVentureId = this.landDao.findLandsByVentureId(ventureId);
		return this.landDTOMapper.mapList(findLandsByVentureId);
	}

	@Override
	public void save(LandDetailDTO landDetailDTO) {
		this.landRepository.save(this.landDTOMapper.map(landDetailDTO));
	}

	@Override
	public void delete(Long landDetailDTOId) {
		this.landRepository.deleteById(landDetailDTOId);
	}

}
