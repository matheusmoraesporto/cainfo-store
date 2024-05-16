package com.cainfo.store.repositories;

import com.cainfo.store.dto.ColorDTO;
import com.cainfo.store.models.ProductColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductColorRepository extends JpaRepository<ProductColor, Integer> {
    @Query(value = "SELECT " +
            "C.VALUE, " +
            "C.HEXADECIMAL, " +
            "PC.ID_COLOR " +
            "FROM PRODUCT_COLOR PC " +
            "JOIN COLOR C ON C.ID = PC.ID_COLOR " +
            "WHERE PC.ID_PRODUCT = :idProduct", nativeQuery = true)
    List<Object[]> listByProductBase(@Param("idProduct") int idProduct);

    default List<ColorDTO> listByProduct(int idProduct) {
        List<Object[]> results = listByProductBase(idProduct);
        return results.stream()
                .map(result -> new ColorDTO(
                        (String) result[0],
                        (String) result[1],
                        (Integer) result[2]))
                .toList();
    }
}
