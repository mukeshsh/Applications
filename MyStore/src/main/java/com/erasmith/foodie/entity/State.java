package com.erasmith.foodie.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2)
    private String uf;

    @OneToMany(mappedBy = "state")
    private List<Company> companies;

    public State() { }

    public State(String name, String uf) {
        this.name = name;
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUf() {
        return uf;
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
