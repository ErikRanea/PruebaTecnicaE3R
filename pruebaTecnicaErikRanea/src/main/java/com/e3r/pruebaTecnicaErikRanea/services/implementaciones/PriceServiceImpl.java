package com.e3r.pruebaTecnicaErikRanea.services.implementaciones;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3r.pruebaTecnicaErikRanea.models.Price;
import com.e3r.pruebaTecnicaErikRanea.repositories.PriceRepository;
import com.e3r.pruebaTecnicaErikRanea.services.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository repositorio;

    @Override
    public List<Price> findAll() {
        return repositorio.findAll();
    }


    @Override
    public Optional<Price> buscarPrecio(Long brandId, Long productId, LocalDateTime fechaDeAplicacion) {
        return repositorio.buscarPrecio(
            brandId, productId, fechaDeAplicacion);
    }



}
