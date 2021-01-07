package com.erasmith.foodie.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erasmith.foodie.dto.MenuDto;
import com.erasmith.foodie.entity.Menu;
import com.erasmith.foodie.form.MenuForm;
import com.erasmith.foodie.response.Response;
import com.erasmith.foodie.service.MenuItemService;
import com.erasmith.foodie.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {


	@Autowired
	private MenuService menuService;

	@Autowired
	private MenuItemService menuItemService;

	@PostMapping
	public ResponseEntity<Response<MenuDto>> create(@RequestBody @Valid MenuForm menuForm, BindingResult bindingResult) {
		Response<MenuDto> response = new Response<>();

		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(error -> response.addError(error.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		Menu menu = menuService.save(menuForm.convertToEntity(menuItemService));
		MenuDto menuDto = MenuDto.transformMenuEntityToMenuDto(menu);

		response.setValue(menuDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<Response<List<MenuDto>>> getByDate(@RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
		Response<List<MenuDto>> response = new Response<>();

		List<Menu> menus = menuService.findBetweenDates(startDate, endDate);
		List<MenuDto> menuDtos = new ArrayList<>();
		menus.forEach(menu -> menuDtos.add(MenuDto.transformMenuEntityToMenuDto(menu)));

		response.setValue(menuDtos);

		return ResponseEntity.ok(response);
	}

}
