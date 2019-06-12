package com.plot.commute.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.plot.commute.entity.Venture;
import com.plot.commute.entity.VillageLkp;
import com.plot.socialnetwork.domain.Person;

public interface VentureRepository extends PagingAndSortingRepository<Venture, Long> {

	@Query("SELECT v FROM Venture v " +
			"WHERE (:person) MEMBER OF v.persons " +
			"   AND LOWER(v.ventureName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
			"ORDER BY v.ventureName")
	Page<Venture> searchUserVentures(
			@Param("person") Person person,
			@Param("searchTerm") String searchTerm,
			Pageable pageRequest);

	@Query("SELECT v FROM Venture v " +
			"WHERE LOWER(v.ventureName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
			"ORDER BY v.ventureName")
	Page<Venture> searchAllVentures(@Param("searchTerm") String searchTerm, Pageable pageRequest);

	@Query("SELECT v FROM Venture v " +
			"WHERE (:villageLkp) MEMBER OF v.villageLkp " +
			"   AND LOWER(v.ventureName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
			"ORDER BY v.ventureName")
	Page<Venture> searchByVillage(VillageLkp villageLkp, String searchTerm, Pageable pageRequest);
}
