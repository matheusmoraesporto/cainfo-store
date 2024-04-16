package com.cainfo.store.controllers;

import com.cainfo.store.dto.PickUpLocationDTO;
import com.cainfo.store.services.PickUpLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PickUpLocationController {
    private final String successfullyCreatedMessage = "Location created successfully";
    private final String successfullyDeletedMessage = "Location deleted successfully";

    @Autowired
    PickUpLocationService service;

    @GetMapping("/location")
    public ResponseEntity<List<PickUpLocationDTO>> listAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listAll());
    }

    @PostMapping("/location")
    public ResponseEntity<String> addPickUpLocation(@RequestBody PickUpLocationDTO locationDTO) {
        var errorMessage = service.addPickUpLocation(locationDTO);
        if (errorMessage.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(successfullyCreatedMessage);
        else
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorMessage);
    }

    @DeleteMapping("/location/{id}")
    public ResponseEntity<String> deletePickUpLocation(
            @PathVariable(value = "id") int id){
        var errorMessage = service.deletePickUpLocation(id);
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
