package com.erasmith.foodie.form;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.erasmith.foodie.entity.Menu;
import com.erasmith.foodie.entity.MenuItem;
import com.erasmith.foodie.service.MenuItemService;

public class MenuForm {
	@NotNull(message = "date must not be null")
    private LocalDate date;
    @NotNull(message = "menuItemIds must not be null")
    private List<Long> menuItemIds;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Long> getMenuItemIds() {
        return menuItemIds;
    }

    public void setMenuItemIds(List<Long> menuItemIds) {
        this.menuItemIds = menuItemIds;
    }

    public Menu convertToEntity(MenuItemService menuItemService) {
        List<MenuItem> menuItems = new ArrayList<>();

        menuItemIds.forEach(menuItemId -> {
            Optional<MenuItem> menuItem = menuItemService.findById(menuItemId);
            if (menuItem.isPresent()) {
                menuItems.add(menuItem.get());
            } else {
                //jogar alguma exceção personalizada
            }
        });
        return new Menu(date, menuItems);
    }
}
