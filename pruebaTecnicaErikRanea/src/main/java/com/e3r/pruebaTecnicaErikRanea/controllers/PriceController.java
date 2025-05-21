package com.e3r.pruebaTecnicaErikRanea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e3r.pruebaTecnicaErikRanea.services.PriceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/prices")
@CrossOrigin(origins = "*")
public class PriceController {

    @Autowired
    private PriceService servicio;

    @PostMapping("path")
    public ResponseEntity<> postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    

}
