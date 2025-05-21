package com.e3r.pruebaTecnicaErikRanea.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e3r.pruebaTecnicaErikRanea.models.Price;



public interface PriceRepository extends JpaRepository<Price,Long> {
    Optional<Price> findByBrandId(Long brandId);
    Optional<Price> findByProductId(Long productId);
}
