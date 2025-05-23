package com.e3r.pruebaTecnicaErikRanea.service.implementation;

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
    private PriceRepository repository;

    @Override
    public List<Price> findAll() {
        return repository.findAll();
    }


    @Override
    public Optional<Price> searchPrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return repository.searchPrice(
            brandId, productId, applicationDate);
    }



}
