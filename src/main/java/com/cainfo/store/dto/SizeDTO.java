package com.cainfo.store.dto;

import com.cainfo.store.models.ProductSize;
import com.cainfo.store.models.Size;
import jakarta.annotation.Nullable;
import org.springframework.beans.BeanUtils;

public record SizeDTO(
        String acronym,
        int length,
        int width,
        @Nullable Integer sleeve,
        @Nullable Integer idSize
        ) {

    public Size toSize() {
        var size = new Size();
        BeanUtils.copyProperties(this, size);
        return size;
    }

    public ProductSize toProductSize() {
        var productSize = new ProductSize();

        if (this.idSize != null)
            productSize.setIdSize(this.idSize);

        return productSize;
    }
}
