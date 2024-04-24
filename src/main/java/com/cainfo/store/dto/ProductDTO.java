package com.cainfo.store.dto;

import com.cainfo.store.models.Product;
import jakarta.annotation.Nullable;
import org.springframework.beans.BeanUtils;

import java.util.List;

public record ProductDTO(
        String name,
        String genre,
        String course,
        double value,
        List<SizeDTO> sizes,
        List<ColorDTO> colors
) {
    public Product toProduct() {
        var product = new Product();
        BeanUtils.copyProperties(this, product);
        return product;
    }
}