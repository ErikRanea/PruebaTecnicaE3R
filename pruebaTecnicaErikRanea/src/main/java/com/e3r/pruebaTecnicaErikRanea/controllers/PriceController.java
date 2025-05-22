package com.e3r.pruebaTecnicaErikRanea.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e3r.pruebaTecnicaErikRanea.dtos.PricePeticionDto;
import com.e3r.pruebaTecnicaErikRanea.dtos.PriceRespuestaDto;
import com.e3r.pruebaTecnicaErikRanea.models.Price;
import com.e3r.pruebaTecnicaErikRanea.services.PriceService;

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

    @PostMapping()
    public ResponseEntity<PriceRespuestaDto> consultaPrecio(
        @RequestBody @Valid PricePeticionDto peticion) {
        
       Optional <Price> price = servicio.buscarPrecio(
            peticion.getBrandId(),
            peticion.getProductId(),
            peticion.getFechaDeAplicacion());
        
        if(!price.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Price priceValido = price.get();

        PriceRespuestaDto respuesta = new PriceRespuestaDto();
        respuesta.setBrandId(priceValido.getBrandId());
        respuesta.setProductId(priceValido.getProductId());
        respuesta.setPriceList(priceValido.getPriceList());
        respuesta.setStartDate(priceValido.getStartDate());
        respuesta.setEndDate(priceValido.getEndDate());
        respuesta.setPrecioFinal(priceValido.getPrice());

        return ResponseEntity.ok().body(respuesta);
    }
    
    @GetMapping()
    public List<Price> getPrices() {
        return servicio.findAll();
    }
    

}
