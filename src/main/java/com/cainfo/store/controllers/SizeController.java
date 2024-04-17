package com.cainfo.store.controllers;

import com.cainfo.store.dto.SizeDTO;
import com.cainfo.store.services.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SizeController {
    private final String successfullyCreatedMessage = "Size created successfully";
    private final String successfullyDeletedMessage = "Size deleted successfully";

    @Autowired
    SizeService service;

    @GetMapping("/size")
    public ResponseEntity<List<SizeDTO>> listAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listAll());
    }

    @PostMapping("/size")
    public ResponseEntity<String> addSize(@RequestBody SizeDTO sizeDTO) {
        var errorMessage = service.addSize(sizeDTO);
        if (errorMessage.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(successfullyCreatedMessage);
        else
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorMessage);
    }

    @DeleteMapping("/size/{id}")
    public ResponseEntity<String> deleteSize(
            @PathVariable(value = "id") int id){
        var errorMessage = service.deleteSize(id);
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
