package com.e3r.pruebaTecnicaErikRanea.services;

import java.util.List;
import java.util.Optional;

import com.e3r.pruebaTecnicaErikRanea.models.Price;

public interface PriceService {
    List<Price> findAll();
    Optional<Price> findByProductId(Long id);
    Optional<Price> findByBrandId(Long id);
}
