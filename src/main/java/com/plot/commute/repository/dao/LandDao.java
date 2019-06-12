package com.plot.commute.repository.dao;

import java.util.List;

import com.plot.commute.entity.LandDetail;

public interface LandDao {

	List<LandDetail> findLandsByVentureId(Long ventureId);

}
