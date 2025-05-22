package com.e3r.pruebaTecnicaErikRanea.service.implement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3r.pruebaTecnicaErikRanea.model.Price;
import com.e3r.pruebaTecnicaErikRanea.repository.PriceRepository;
import com.e3r.pruebaTecnicaErikRanea.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository repositorio;

    @Override
    public List<Price> findAll() {
        return repositorio.findAll();
    }


    @Override
    public Optional<Price> searchPrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return repositorio.searchPrice(
            brandId, productId, applicationDate);
    }



}
