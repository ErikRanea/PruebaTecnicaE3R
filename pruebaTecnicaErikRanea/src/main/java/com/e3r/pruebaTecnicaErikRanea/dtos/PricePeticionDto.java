package com.e3r.pruebaTecnicaErikRanea.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PricePeticionDto {


    @JsonProperty("brand_id")
    private Long brandId;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("fecha_aplicacion")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaDeAplicacion;

    public PricePeticionDto(){}

    public PricePeticionDto(Long brandId, Long productId, LocalDateTime fechaDeAplicacion) {
        this.brandId = brandId;
        this.productId = productId;
        this.fechaDeAplicacion = fechaDeAplicacion;
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

    public LocalDateTime getFechaDeAplicacion() {
        return fechaDeAplicacion;
    }

    public void setFechaDeAplicacion(LocalDateTime fechaDeAplicacion) {
        this.fechaDeAplicacion = fechaDeAplicacion;
    }

    

}
