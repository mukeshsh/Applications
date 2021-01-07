package com.erasmith.foodie.dto;

import com.erasmith.foodie.entity.MenuItem;

public class MenuItemDto {
	private Long id;
    private String name;

    public MenuItemDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static MenuItemDto transformMenuItemEntityToMenuItemDto(MenuItem menuItem) {
        return new MenuItemDto(menuItem.getId(), menuItem.getName());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
