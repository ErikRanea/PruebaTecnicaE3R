package com.e3r.pruebaTecnicaErikRanea.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PricePeticionDto {


    @JsonProperty("brand_id")
    private Long brandId;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("fecha_aplicacion")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaDeAplicacion;
 

}
