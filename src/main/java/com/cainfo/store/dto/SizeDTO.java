package com.cainfo.store.dto;

import com.cainfo.store.models.Size;
import org.springframework.beans.BeanUtils;

public record SizeDTO(
        String acronym,
        int length,
        int width
) {
    public Size toSize() {
        var size = new Size();
        BeanUtils.copyProperties(this, size);
        return size;
    }
}
