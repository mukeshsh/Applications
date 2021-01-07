package com.erasmith.foodie.form;

import javax.validation.constraints.NotNull;

public class MenuItemForm {
	 @NotNull(message = "name must not be null")
	    private String name;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
	}

