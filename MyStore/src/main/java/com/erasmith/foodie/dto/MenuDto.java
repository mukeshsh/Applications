package com.erasmith.foodie.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.erasmith.foodie.entity.Menu;

public class MenuDto {
	private Long id;
    private LocalDate date;
    private List<MenuItemDto> menuItens;

    private MenuDto(Long id, LocalDate date, List<MenuItemDto> menuItens) {
        this.id = id;
        this.date = date;
        this.menuItens = menuItens;
    }

    public static MenuDto transformMenuEntityToMenuDto(Menu menu) {
        List<MenuItemDto> menuItemDtos = new ArrayList<>();
        menu.getMenuItems().forEach(menuItem -> {
            menuItemDtos.add(MenuItemDto.transformMenuItemEntityToMenuItemDto(menuItem));
        });
        return new MenuDto(menu.getId(), menu.getDate(), menuItemDtos);
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<MenuItemDto> getMenuItens() {
        return menuItens;
    }
}
