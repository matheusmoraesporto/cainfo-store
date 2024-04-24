package com.cainfo.store.services;

import com.cainfo.store.dto.ColorDTO;
import com.cainfo.store.repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    private final String colorNotFoundMessage = "Color not found";
    @Autowired
    ColorRepository repository;

    public List<ColorDTO> listAll() {
        var colors = repository.findAll();
        return colors
                .stream()
                .map(c -> new ColorDTO(
                        c.getValue(),
                        c.getHexadecimal(),
                        c.getId()))
                .toList();
    }

    public String addColor(ColorDTO dto) {
        var newColor = dto.toColor();
        if (colorAlreadyExists(newColor.getValue())) {
            return "Color " + newColor.getValue() + " already exists!";
        }

        try {
            repository.save(newColor);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "";
    }

    public String deleteColor(int id) {
        var color = repository.findById(id);
        if (color.isEmpty()) {
            return colorNotFoundMessage;
        }

        try {
            repository.delete(color.get());
        } catch (Exception e) {
            return e.getMessage();
        }
        return "";
    }

    private boolean colorAlreadyExists(String value) {
        return !repository.findByValue(value).isEmpty();
    }
}
