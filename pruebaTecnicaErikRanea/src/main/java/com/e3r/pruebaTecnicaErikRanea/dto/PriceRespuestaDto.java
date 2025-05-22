package com.e3r.pruebaTecnicaErikRanea.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PriceRespuestaDto {

    @JsonProperty("brandId")
    private Long brandId;
    
    @JsonProperty("productId")
    private Long productId;
    
    @JsonProperty("priceList")
    private int priceList;
    
    @JsonProperty("startDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;
    
    @JsonProperty("endDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;

    @JsonProperty("price")
    private double price;

    
    

}
