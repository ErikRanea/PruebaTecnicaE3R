package com.e3r.pruebaTecnicaErikRanea.mapper;

import org.mapstruct.Mapper;

import com.e3r.pruebaTecnicaErikRanea.dto.PriceResponseDto;
import com.e3r.pruebaTecnicaErikRanea.model.Price;

@Mapper(componentModel = "spring")
public interface PriceMapper {


    PriceResponseDto toDto(Price price);

}
