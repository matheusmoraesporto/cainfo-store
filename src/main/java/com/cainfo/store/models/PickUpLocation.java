package com.cainfo.store.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PICK_UP_LOCATION")
public class PickUpLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
