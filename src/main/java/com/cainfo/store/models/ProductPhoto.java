package com.cainfo.store.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT_PHOTO")
public class ProductPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "URL", nullable = false)
    private String url;

    @Column(name = "THUMB", nullable = false)
    private boolean thumb;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;

    public String getUrl() {
        return url;
    }

    public boolean isThumb() {
        return thumb;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setThumb(boolean thumb) {
        this.thumb = thumb;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
