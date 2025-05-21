package com.e3r.pruebaTecnicaErikRanea.repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.e3r.pruebaTecnicaErikRanea.models.Price;



public interface PriceRepository extends JpaRepository<Price,Long> {

    @Query("""
            SELECT p FROM Price p 
            WHERE p.brandId = :brandId
            AND p.productId = :productId
            AND :fecha BETWEEN p.startDate and p.endDate
            ORDER BY p.priority DESC
            LIMIT 1
            """)
    Optional<Price> buscarPrecio(
        Long brandId,
        Long productId,
        LocalDateTime fecha
    );
    


}
