package com.erasmith.foodie.form;

import java.time.LocalDate;

public class OrderForm {

    private LocalDate date;
    private Long itemIds;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getItemIds() {
        return itemIds;
    }

    public void setItemIds(Long itemIds) {
        this.itemIds = itemIds;
    }
}
