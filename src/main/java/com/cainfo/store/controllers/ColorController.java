package com.cainfo.store.controllers;

import com.cainfo.store.dto.ColorDTO;
import com.cainfo.store.services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ColorController {
    private final String successfullyCreatedMessage = "Color created successfully";
    private final String successfullyDeletedMessage = "Color deleted successfully";

    @Autowired
    ColorService service;

    @GetMapping("/color")
    public ResponseEntity<List<ColorDTO>> listAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listAll());
    }

    @PostMapping("/color")
    public ResponseEntity<String> addColor(@RequestBody ColorDTO colorDTO) {
        var errorMessage = service.addColor(colorDTO);
        if (errorMessage.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(successfullyCreatedMessage);
        else
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorMessage);
    }

    @DeleteMapping("/color/{id}")
    public ResponseEntity<String> deleteColor(
            @PathVariable(value = "id") int id){
        var errorMessage = service.deleteColor(id);
        if (errorMessage.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(successfullyDeletedMessage);
        else
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorMessage);
    }
}
