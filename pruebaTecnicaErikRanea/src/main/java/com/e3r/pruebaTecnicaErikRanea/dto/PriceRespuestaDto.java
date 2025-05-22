package com.e3r.pruebaTecnicaErikRanea.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
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

    @JsonProperty("price")
    private double price;

    
    

}
