package com.plot.commute.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plot.commute.entity.VillageLkp;

public interface BaseLkpRepository extends JpaRepository<VillageLkp, Long> {

}
