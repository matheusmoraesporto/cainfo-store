package com.cainfo.store.repositories;

import com.cainfo.store.dto.SizeDTO;
import com.cainfo.store.models.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSize, Integer> {
    @Query(value = "SELECT " +
            "S.ACRONYM," +
            "S.LENGTH, " +
            "S.WIDTH," +
            "S.SLEEVE," +
            "PS.ID_SIZE " +
            "FROM PRODUCT_SIZE PS " +
            "JOIN SIZE S ON S.ID = PS.ID_SIZE " +
            "WHERE PS.ID_PRODUCT = :idProduct", nativeQuery = true)
    List<Object[]> listByProductBase(@Param("idProduct") int idProduct);

    default List<SizeDTO> listByProduct(int idProduct) {
        List<Object[]> results = listByProductBase(idProduct);
        return results
                .stream()
                .map(result -> new SizeDTO(
                        (String) result[0],
                        (int) result[1],
                        (int) result[2],
                        (Integer) result[3],
                        (Integer) result[4]))
                .toList();
    }
}
