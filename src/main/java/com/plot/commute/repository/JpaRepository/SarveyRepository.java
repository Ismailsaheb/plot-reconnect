package com.plot.commute.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plot.commute.entity.SarveyDetail;
import com.plot.commute.entity.Venture;

public interface SarveyRepository extends JpaRepository<SarveyDetail, Long> {

	// @Query("SELECT s FROM SarveyDetail s WHERE (:venture) MEMBER OF s.venture
	// ORDER BY s.sarvayNo")
	List<SarveyDetail> findSarvaysByVenture(Venture venture);
}
