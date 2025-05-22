package com.e3r.pruebaTecnicaErikRanea.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.e3r.pruebaTecnicaErikRanea.dto.PriceRespuestaDto;
import com.e3r.pruebaTecnicaErikRanea.model.Price;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "price", target = "price")
    PriceRespuestaDto toDto(Price price);

}
