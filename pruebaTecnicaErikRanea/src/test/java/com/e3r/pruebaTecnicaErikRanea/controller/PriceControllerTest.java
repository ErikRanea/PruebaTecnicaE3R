package com.e3r.pruebaTecnicaErikRanea.controller;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.e3r.pruebaTecnicaErikRanea.dto.PriceResponseDto;
import com.e3r.pruebaTecnicaErikRanea.mapper.PriceMapper;
import com.e3r.pruebaTecnicaErikRanea.model.Price;
import com.e3r.pruebaTecnicaErikRanea.service.PriceService;

@WebMvcTest(PriceController.class)
public class PriceControllerTest {

   
    @Autowired 
    private MockMvc mockMvc;
    
    @MockBean
    private PriceService service;

    @MockBean
    private PriceMapper mapper;

    @Test
    void getPrices_whenPricesExist_shouldReturnOkWithListOfPriceResponseDtos() throws Exception{

        LocalDateTime date = LocalDateTime.now();
        Price price1 = new Price(1L,1L,date.minusDays(1),date.plusDays(1),1,35455L,0,25.50,"EUR");
        Price price2 = new Price(2L,1L,date.minusDays(2),date.plusDays(2),2,35455L,1,15.50,"EUR");

        List<Price> pricesFromService = Arrays.asList(price1,price2);

        PriceResponseDto dto1 = new PriceResponseDto();
        dto1.setBrandId(price1.getBrandId());
        dto1.setPrice(price1.getPrice());
        dto1.setProductId(price1.getProductId());
        dto1.setPriceList(price1.getPriceList());
        dto1.setStartDate(price1.getStartDate());
        dto1.setEndDate(price1.getEndDate());

        PriceResponseDto dto2 = new PriceResponseDto();
        dto2.setBrandId(price2.getBrandId());
        dto2.setPrice(price2.getPrice());
        dto2.setProductId(price2.getProductId());
        dto2.setPriceList(price2.getPriceList());
        dto2.setStartDate(price2.getStartDate());
        dto2.setEndDate(price2.getEndDate());


        when(this.service.findAll()).thenReturn(pricesFromService);
        when(this.mapper.toDto(price1)).thenReturn(dto1);
        when(this.mapper.toDto(price2)).thenReturn(dto2);

        ResultActions resultActions = mockMvc.perform(get("/api/prices")
                .accept(MediaType.APPLICATION_JSON));
        

        resultActions
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].price", is(price1.getPrice())))
            .andExpect(jsonPath("$[1].price", is(price2.getPrice())));

        verify(this.service).findAll();
        verify(this.mapper).toDto(price1);
        verify(this.mapper).toDto(price2);


        verifyNoMoreInteractions(this.service, this.mapper);
    }

    @Test
    void getPrices_whenPricesNoExist_shouldReturnOkWithEmptyList() throws Exception{

        when(service.findAll()).thenReturn(Collections.emptyList());

        ResultActions resultActions = mockMvc.perform(get("/api/prices")
                .accept(MediaType.APPLICATION_JSON));

         resultActions
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(0)))
            .andExpect(content().json("[]"));

        verify(service).findAll();
        verifyNoMoreInteractions(service);
        
    }

}
