package com.cainfo.store.services;

import com.cainfo.store.dto.SizeDTO;
import com.cainfo.store.repositories.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {
    private final String sizeNotFoundMessage = "Size not found";
    private final String duplicatedSizeMessage = "Size already exists!";
    @Autowired
    SizeRepository repository;

    public List<SizeDTO> listAll() {
        var sizes = repository.findAll();
        return sizes
                .stream()
                .map(s -> new SizeDTO(
                        s.getAcronym(),
                        s.getLength(),
                        s.getWidth(),
                        s.getSleeve(),
                        s.getId()))
                .toList();
    }

    public String addSize(SizeDTO dto) {
        var newSize = dto.toSize();
        if (sizeAlreadyExists(newSize.getAcronym(), newSize.getLength(), newSize.getWidth())) {
            return duplicatedSizeMessage;
        }

        try {
            repository.save(newSize);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "";
    }

    public String deleteSize(int id) {
        var size = repository.findById(id);
        if (size.isEmpty()) {
            return sizeNotFoundMessage;
        }

        try {
            repository.delete(size.get());
        } catch (Exception e) {
            return e.getMessage();
        }
        return "";
    }

    private boolean sizeAlreadyExists(String acronym, int length, int width) {
        return !repository.findByAcronymAndLengthAndWidth(acronym, length, width).isEmpty();
    }
}
