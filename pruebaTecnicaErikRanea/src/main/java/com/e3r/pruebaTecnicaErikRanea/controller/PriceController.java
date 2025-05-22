package com.e3r.pruebaTecnicaErikRanea.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e3r.pruebaTecnicaErikRanea.dto.PricePeticionDto;
import com.e3r.pruebaTecnicaErikRanea.dto.PriceRespuestaDto;
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
    private PriceService servicio;

    @Autowired
    private PriceMapper mapper;

    @PostMapping()
    public ResponseEntity<PriceRespuestaDto> checkPrice(
        @RequestBody @Valid PricePeticionDto peticion) {
        
       Optional <Price> price = servicio.searchPrice(
            peticion.getBrandId(),
            peticion.getProductId(),
            peticion.getApplicationDate());
        
        if(!price.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok().body(mapper.toDto(price.get()));
    }
    
    @GetMapping()
    public List<Price> getPrices() {
        return servicio.findAll();
    }
    

}
