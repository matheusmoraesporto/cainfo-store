package com.cainfo.store.dto;

import com.cainfo.store.models.ProductPhoto;
import org.springframework.beans.BeanUtils;

public record PhotoDTO(String url, boolean thumb) {

    public ProductPhoto toProductPhoto() {
        var productPhoto = new ProductPhoto();
        BeanUtils.copyProperties(this, productPhoto);
        return productPhoto;
    }
}
