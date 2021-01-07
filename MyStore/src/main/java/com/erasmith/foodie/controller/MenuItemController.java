package com.erasmith.foodie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erasmith.foodie.dto.MenuItemDto;
import com.erasmith.foodie.entity.MenuItem;
import com.erasmith.foodie.form.MenuItemForm;
import com.erasmith.foodie.response.Response;
import com.erasmith.foodie.service.MenuItemService;

@RestController
@RequestMapping("/menuItem")
public class MenuItemController {


	@Autowired
	private MenuItemService menuItemService;

	@PostMapping
	public ResponseEntity<Response<MenuItemDto>> create(@RequestBody @Valid MenuItemForm menuItemForm, BindingResult bindingResult) {
		Response<MenuItemDto> response = new Response<>();

		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(error -> response.addError(error.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		MenuItem menuItem = menuItemService.save(converFormToEntity(menuItemForm));
		MenuItemDto menuItemDto = convertEntityToDto(menuItem);
		response.setValue(menuItemDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<Response<List<MenuItemDto>>> getAll() {
		Response<List<MenuItemDto>> response = new Response<>();
		List<MenuItem> menuItems = menuItemService.findAll();
		List<MenuItemDto> menuItemDtos = new ArrayList<>();
		menuItems.forEach(menuItem -> menuItemDtos.add(convertEntityToDto(menuItem)));
		response.setValue(menuItemDtos);
		return ResponseEntity.ok(response);
	}

	private MenuItem converFormToEntity(MenuItemForm menuItemDto) {
		return new MenuItem(menuItemDto.getName());
	}

	private MenuItemDto convertEntityToDto(MenuItem menuItem) {
		return new MenuItemDto(menuItem.getId(), menuItem.getName());
	}


}
