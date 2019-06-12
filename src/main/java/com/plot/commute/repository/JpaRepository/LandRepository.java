package com.plot.commute.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plot.commute.entity.LandDetail;

public interface LandRepository extends JpaRepository<LandDetail, Long> {

}
