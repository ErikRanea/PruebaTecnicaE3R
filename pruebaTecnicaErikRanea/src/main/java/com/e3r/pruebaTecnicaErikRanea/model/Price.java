package com.e3r.pruebaTecnicaErikRanea.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prices")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "BrandID es requerido")
    private Long brandId;

    @NotNull(message = "StartDate es requerido")
    private LocalDateTime startDate;

    @NotNull(message = "EndDate es requerido")
    private LocalDateTime endDate;

    @NotNull(message = "PriceList es requerido")
    @Positive(message = "PriceList debe ser positivo")
    private int priceList;

    @NotNull(message = "ProductId es requerido")
    private Long productId;

    @Min(value = 0, message = "La prioridad debe ser 0 o superior")
    private int priority;

    @Positive(message = "El precio debe ser mayor a 0")
    private double price;

    @NotNull(message = "La iso de la moneda es requerida")
    @Pattern(regexp = "EUR", message = "Las ISO debe EUR")
    private String curr;


}
