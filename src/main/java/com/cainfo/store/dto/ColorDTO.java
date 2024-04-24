package com.cainfo.store.dto;

import com.cainfo.store.models.Color;
import com.cainfo.store.models.ProductColor;
import com.cainfo.store.models.ProductSize;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

public record ColorDTO(
        String value,
        String hexadecimal,
        @Nullable Integer idColor) {
    public Color toColor() {
        var newColor = new Color();
        BeanUtils.copyProperties(this, newColor);
        return newColor;
    }

    public ProductColor toProductColor() {
        var productColor = new ProductColor();

        if (this.idColor != null)
            productColor.setIdColor(this.idColor);

        return productColor;
    }
}
