package com.erasmith.foodie.service;

import java.time.LocalDate;
import java.util.List;

import com.erasmith.foodie.entity.Menu;

public interface MenuService {
	  Menu save(Menu menu);
	    List<Menu> findBetweenDates(LocalDate startDate, LocalDate endDate);
}
