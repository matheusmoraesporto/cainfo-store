package com.cainfo.store.repositories;

import com.cainfo.store.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SizeRepository extends JpaRepository<Size, Integer> {
    Optional<Size> findByAcronymAndLengthAndWidth(String acronym, int length, int width);
}
