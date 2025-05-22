package com.e3r.pruebaTecnicaErikRanea.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e3r.pruebaTecnicaErikRanea.dto.PriceRequestDto;
import com.e3r.pruebaTecnicaErikRanea.dto.PriceResponseDto;
import com.e3r.pruebaTecnicaErikRanea.mapper.PriceMapper;
import com.e3r.pruebaTecnicaErikRanea.model.Price;
import com.e3r.pruebaTecnicaErikRanea.service.PriceService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/prices")
@CrossOrigin(origins = "*")
public class PriceController {

    @Autowired
    private PriceService service;

    @Autowired
    private PriceMapper mapper;

    @PostMapping()
    public ResponseEntity<PriceResponseDto> checkPrice(
        @RequestBody @Valid PriceRequestDto request) {
        
       Optional <Price> price = service.searchPrice(
            request.getBrandId(),
            request.getProductId(),
            request.getApplicationDate());
        
        if(!price.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(mapper.toDto(price.get()));
    }
    
    @GetMapping()
    public List<Price> getPrices() {
        return service.findAll();
    }
    

}
