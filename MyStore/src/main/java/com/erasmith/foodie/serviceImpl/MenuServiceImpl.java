package com.erasmith.foodie.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erasmith.foodie.entity.Menu;
import com.erasmith.foodie.repository.MenuRepository;
import com.erasmith.foodie.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> findBetweenDates(LocalDate startDate, LocalDate endDate) {
        return menuRepository.findAllBetweenDates(startDate, endDate);
    }
}
