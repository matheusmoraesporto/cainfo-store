package com.cainfo.store.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT_COLOR")
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ID_COLOR", nullable = false)
    private int idColor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
