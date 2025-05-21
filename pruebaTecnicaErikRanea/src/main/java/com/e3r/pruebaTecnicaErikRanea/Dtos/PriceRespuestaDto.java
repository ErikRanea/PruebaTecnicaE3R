package com.e3r.pruebaTecnicaErikRanea.Dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceRespuestaDto {

    @JsonProperty("brand_id")
    private Long brandId;
    
    @JsonProperty("product_id")
    private Long productId;
    
    @JsonProperty("price_list")
    private int priceList;
    
    @JsonProperty("start_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;
    
    @JsonProperty("end_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;

    @JsonProperty("precio_final")
    private double precioFinal;

    public PriceRespuestaDto(){}

    public PriceRespuestaDto(Long brandId, Long productId, int priceList, LocalDateTime startDate,
            LocalDateTime endDate, double precioFinal) {
        this.brandId = brandId;
        this.productId = productId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.precioFinal = precioFinal;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
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

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    

}
