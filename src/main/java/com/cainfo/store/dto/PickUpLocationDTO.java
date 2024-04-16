package com.cainfo.store.dto;

import com.cainfo.store.models.PickUpLocation;
import org.springframework.beans.BeanUtils;

public record PickUpLocationDTO(String name) {
    public PickUpLocation toPickUpLocation() {
        var newLocation = new PickUpLocation();
        BeanUtils.copyProperties(this, newLocation);
        return newLocation;
    }
}
