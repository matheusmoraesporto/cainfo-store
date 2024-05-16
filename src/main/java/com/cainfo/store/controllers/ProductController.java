package com.cainfo.store.controllers;

import com.cainfo.store.dto.ProductDTO;
import com.cainfo.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final String successfullyCreatedMessage = "Product created successfully";
    private final String successfullyDeletedMessage = "Product deleted successfully";

    @Autowired
    ProductService service;

    @GetMapping("/product")
    public ResponseEntity<List<ProductDTO>> listAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listAll());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(
            @PathVariable("id") int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getProductById(id));
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) {
        var errorMessage = service.addProduct(productDTO);
        if (errorMessage.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(successfullyCreatedMessage);
        else
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorMessage);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable(value = "id") int id){
        var errorMessage = service.deleteProduct(id);
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
