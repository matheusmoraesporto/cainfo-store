package com.cainfo.store.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT_SIZE")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "ID_SIZE", nullable = false)
    private int idSize;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
