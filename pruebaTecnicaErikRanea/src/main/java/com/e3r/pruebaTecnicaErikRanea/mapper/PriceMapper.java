package com.e3r.pruebaTecnicaErikRanea.mapper;

import org.mapstruct.Mapper;

import com.e3r.pruebaTecnicaErikRanea.dto.PriceRespuestaDto;
import com.e3r.pruebaTecnicaErikRanea.model.Price;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceRespuestaDto tDto(Price price);

}
    