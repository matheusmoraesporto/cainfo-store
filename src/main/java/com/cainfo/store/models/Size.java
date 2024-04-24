package com.cainfo.store.models;

import jakarta.persistence.*;

@Entity
@Table(name = "SIZE")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ACRONYM", length = 5, nullable = false)
    private String acronym;

    @Column(name = "LENGTH", nullable = false)
    private int length;

    @Column(name = "WIDTH", nullable = false)
    private int width;

    @Column(name = "SLEEVE")
    private int sleeve;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSleeve() {
        return sleeve;
    }

    public void setSleeve(int sleeve) {
        this.sleeve = sleeve;
    }
}
