package com.e3r.pruebaTecnicaErikRanea.models;

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

@Entity
@Table(name = "prices")
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
    @Pattern(regexp = "EUR|USD", message = "Las ISO deben ser EUR o USD")
    private String curr;


    
    
    public Price(Long brandId, @NotNull(message = "StartDate es requerido") LocalDateTime startDate,
            @NotNull(message = "EndDate es requerido") LocalDateTime endDate,
            @NotNull(message = "PriceList es requerido") @Positive(message = "PriceList debe ser positivo") int priceList,
            @NotNull(message = "ProductId es requerido") Long productId,
            @Min(value = 0, message = "La prioridad debe ser 0 o superior") int priority,
            @Positive(message = "El precio debe ser mayor a 0") double price,
            @NotNull(message = "La iso de la moneda es requerida") @Pattern(regexp = "EUR|USD", message = "Las ISO deben ser EUR o USD") String curr) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }
    public Price(){}

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    


}
