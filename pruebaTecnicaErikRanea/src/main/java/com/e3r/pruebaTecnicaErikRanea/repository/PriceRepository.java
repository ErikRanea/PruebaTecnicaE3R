package com.e3r.pruebaTecnicaErikRanea.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.e3r.pruebaTecnicaErikRanea.model.Price;



public interface PriceRepository extends JpaRepository<Price,Long> {

    @Query("""
            SELECT p FROM Price p 
            WHERE p.brandId = :brandId
            AND p.productId = :productId
            AND :applicationDate BETWEEN p.startDate and p.endDate
            ORDER BY p.priority DESC
            LIMIT 1
            """)
    Optional<Price> searchPrice(
        Long brandId,
        Long productId,
        LocalDateTime applicationDate
    );
    


}
