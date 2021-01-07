package com.erasmith.foodie.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDate date;

	@ManyToMany
	private List<MenuItem> menuItems;

	public Menu() {
	}

	public Menu(LocalDate date, List<MenuItem> menuItems) {
		this.date = date;
		this.menuItems = menuItems;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}


}
