package com.e3r.pruebaTecnicaErikRanea.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.e3r.pruebaTecnicaErikRanea.models.Price;
import com.e3r.pruebaTecnicaErikRanea.repositories.PriceRepository;

@Component
public class InicializarDatos implements CommandLineRunner {

    private final PriceRepository repositorio;

    public InicializarDatos(PriceRepository repositorio){
        this.repositorio = repositorio;
    }

    @Override
    public void run(String... args){
        if(repositorio.count() == 0){
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
            
              List<Price> prices = List.of(
                new Price(1L,
                    LocalDateTime.parse("2020-06-14-00.00.00", formato),
                    LocalDateTime.parse("2020-12-31-23.59.59", formato),
                    1, 35455L, 0, 35.50, "EUR"),

                new Price(1L,
                    LocalDateTime.parse("2020-06-14-15.00.00", formato),
                    LocalDateTime.parse("2020-06-14-18.30.00", formato),
                    2, 35455L, 1, 25.45, "EUR"),

                new Price(1L,
                    LocalDateTime.parse("2020-06-15-00.00.00", formato),
                    LocalDateTime.parse("2020-06-15-11.00.00", formato),
                    3, 35455L, 1, 30.50, "EUR"),

                new Price(1L,
                    LocalDateTime.parse("2020-06-15-16.00.00", formato),
                    LocalDateTime.parse("2020-12-31-23.59.59", formato),
                    4, 35455L, 1, 38.95, "EUR")
            );
            repositorio.saveAll(prices);
            repositorio.findAll().forEach(System.out::println);
            System.out.println("Se ha inicializado correctamente los datos de prueba");
        }
    }

}
