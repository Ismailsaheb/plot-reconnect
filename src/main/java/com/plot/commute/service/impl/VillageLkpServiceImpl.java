package com.plot.commute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.plot.commute.entity.VillageLkp;
import com.plot.commute.repository.JpaRepository.VillageLkpRepository;

@Service
@Transactional
public class VillageLkpServiceImpl {

	@Autowired
	private VillageLkpRepository villageLkpRepository;

	public void save(VillageLkp villageLkp) {
		this.villageLkpRepository.save(villageLkp);
	}

	public void delete(Long villageLkpId) {
		this.villageLkpRepository.deleteById(villageLkpId);
	}

	public List<VillageLkp> findAll() {
		return this.villageLkpRepository.findAll();
	}
}
