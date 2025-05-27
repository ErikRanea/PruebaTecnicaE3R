package com.e3r.pruebaTecnicaErikRanea.dto;

import java.time.LocalDateTime;


import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PriceRequestDto {


    @JsonProperty("brand_id")
    @NotNull(message = "El campo brand_id es requerido")
    private Long brandId;

    @JsonProperty("product_id")
    @NotNull(message = "El campo product_id es requerido")
    private Long productId;

    @JsonProperty("application_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @NotNull(message = "El campo application_date es requerido")
    private LocalDateTime applicationDate;
 

}
