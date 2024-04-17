package com.cainfo.store.dto;

import com.cainfo.store.models.Color;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

public record ColorDTO(String value, String hexadecimal) {
    public Color toColor() {
        var newColor = new Color();
        BeanUtils.copyProperties(this, newColor);
        return newColor;
    }
}
