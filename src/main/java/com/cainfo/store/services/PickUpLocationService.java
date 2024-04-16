package com.cainfo.store.services;

import com.cainfo.store.dto.PickUpLocationDTO;
import com.cainfo.store.repositories.PickUpLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PickUpLocationService {
    @Autowired
    PickUpLocationRepository repository;

    public List<PickUpLocationDTO> listAll() {
        var locations = repository.findAll();
        return locations
                .stream()
                .map(c -> new PickUpLocationDTO(c.getName()))
                .toList();
    }

    public String addPickUpLocation(PickUpLocationDTO dto) {
        var newPickUpLocation = dto.toPickUpLocation();
        if (pickUpLocationAlreadyExists(newPickUpLocation.getName())) {
            return "Pick up location " + newPickUpLocation.getName() + " already exists!";
        }

        try {
            repository.save(newPickUpLocation);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "";
    }

    public String deletePickUpLocation(int id) {
        var location = repository.findById(id);
        if (location.isEmpty()) {
            return "Pick up location not found";
        }

        try {
            repository.delete(location.get());
        } catch (Exception e) {
            return e.getMessage();
        }
        return "";
    }

    private boolean pickUpLocationAlreadyExists(String name) {
        return !repository.findByName(name).isEmpty();
    }
}
