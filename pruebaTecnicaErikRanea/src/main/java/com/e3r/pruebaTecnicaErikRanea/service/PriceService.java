package com.e3r.pruebaTecnicaErikRanea.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.e3r.pruebaTecnicaErikRanea.model.Price;

public interface PriceService {
    List<Price> findAll();
    Optional<Price> buscarPrecio(
        Long brandId,
        Long productId,
        LocalDateTime fechaDeAplicacion
    );
}