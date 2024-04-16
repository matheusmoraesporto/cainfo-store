package com.cainfo.store.repositories;

import com.cainfo.store.models.PickUpLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PickUpLocationRepository extends JpaRepository<PickUpLocation, Integer> {
    Optional<PickUpLocation> findByName(String name);
}
