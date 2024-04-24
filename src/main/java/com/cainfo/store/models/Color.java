package com.cainfo.store.models;

import jakarta.persistence.*;

@Entity
@Table(name = "COLOR")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "VALUE", nullable = false)
    private String value;

    @Column(name = "HEXADECIMAL")
    private String hexadecimal;

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getHexadecimal() {
        return hexadecimal;
    }

    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }
}
