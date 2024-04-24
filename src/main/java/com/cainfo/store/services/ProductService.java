package com.cainfo.store.services;

import com.cainfo.store.dto.ColorDTO;
import com.cainfo.store.dto.ProductDTO;
import com.cainfo.store.dto.SizeDTO;
import com.cainfo.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final String duplicatedProductMessage = "Product already exists!";
    private final String productNotFoundMessage = "Product not found";
    @Autowired
    ProductRepository repository;

    public List<ProductDTO> listAll() {
        // TODO: Create a query?
        var products = repository.findAll();
        return products
                .stream()
                .map(p -> new ProductDTO(
                        p.getName(),
                        p.getGenre(),
                        p.getCourse(),
                        p.getValue(),
                        null,
                        null))
                .toList();
    }

    public String addProduct(ProductDTO dto) {
        var newProduct = dto.toProduct();
        if (productAlreadyExists(newProduct.getName(), newProduct.getGenre(), newProduct.getCourse()))
            return duplicatedProductMessage;

        for (SizeDTO size : dto.sizes()) {
            var ps = size.toProductSize();
            ps.setProduct(newProduct);
            newProduct.getSizes().add(ps);
        }

        for (ColorDTO color : dto.colors()) {
            var pc = color.toProductColor();
            pc.setProduct(newProduct);
            newProduct.getColors().add(pc);
        }

        try {
            repository.save(newProduct);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "";
    }

    public String deleteProduct(int id) {
        var product = repository.findById(id);
        if (product.isEmpty())
            return productNotFoundMessage;

        try {
            repository.delete(product.get());
        } catch (Exception e) {
            return e.getMessage();
        }
        return "";
    }

    private boolean productAlreadyExists(String name, String genre, String course) {
        return !repository.findByNameAndGenreAndCourse(name, genre, course).isEmpty();
    }
}