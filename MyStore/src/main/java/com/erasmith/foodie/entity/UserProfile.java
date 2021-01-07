package com.erasmith.foodie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class UserProfile implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String profileName;

    public UserProfile() { }

    public UserProfile(String profileName) {
        this.profileName = profileName;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getAuthority() {
        return profileName;
    }
}
