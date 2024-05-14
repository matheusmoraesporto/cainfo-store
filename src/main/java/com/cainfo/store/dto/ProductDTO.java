package com.cainfo.store.dto;

import com.cainfo.store.models.Product;
import org.springframework.beans.BeanUtils;

import java.util.List;

public record ProductDTO(
        Number id,
        String name,
        String genre,
        String course,
        double value,
        String thumbPhoto,
        List<SizeDTO> sizes,
        List<ColorDTO> colors,
        List<PhotoDTO> photos
) {
    public Product toProduct() {
        var product = new Product();
        BeanUtils.copyProperties(this, product);
        return product;
    }
}
