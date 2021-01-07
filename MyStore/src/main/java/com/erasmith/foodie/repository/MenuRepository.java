package com.erasmith.foodie.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.erasmith.foodie.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	@Query("SELECT menu FROM Menu menu WHERE (menu.date BETWEEN :startDate and :endDate)")
	List<Menu> findAllBetweenDates(@Param("startDate") LocalDate startDate,
			@Param("endDate") LocalDate endDate);


}
