package com.e3r.pruebaTecnicaErikRanea.intregation;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.e3r.pruebaTecnicaErikRanea.dto.PriceRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PriceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private  ObjectMapper objectMapper;

    @Test
    public void shouldApplyPriceList1_whenRequestIsForJune14thAt10AM() throws Exception{
        
        PriceRequestDto request = new PriceRequestDto();
        request.setProductId(35455L);
        request.setBrandId(1L);
        request.setApplicationDate(LocalDateTime.of(2020, 6, 14, 10, 0, 0));
        
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/prices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(35.50))
        .andExpect(jsonPath("$.priceList").value(1));


    }

    @Test
    public void shouldApplyPriceList2_whenRequestIsForJune14thAt4AM() throws Exception{
        
        PriceRequestDto request = new PriceRequestDto();
        request.setProductId(35455L);
        request.setBrandId(1L);
        request.setApplicationDate(LocalDateTime.of(2020, 6, 14, 16, 0, 0));
        
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/prices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(25.45))
        .andExpect(jsonPath("$.priceList").value(2));
    }

    @Test
    public void shouldApplyPriceList1_whenRequestIsForJune14thAt9PM() throws Exception{
        
        PriceRequestDto request = new PriceRequestDto();
        request.setProductId(35455L);
        request.setBrandId(1L);
        request.setApplicationDate(LocalDateTime.of(2020, 6, 14, 21, 0, 0));
        
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/prices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(35.5))
        .andExpect(jsonPath("$.priceList").value(1));
    }

    @Test
    public void shouldApplyPriceList3_whenRequestIsForJune15thAt10AM() throws Exception{
        
        PriceRequestDto request = new PriceRequestDto();
        request.setProductId(35455L);
        request.setBrandId(1L);
        request.setApplicationDate(LocalDateTime.of(2020, 6, 15, 10, 0, 0));
        
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/prices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(30.50))
        .andExpect(jsonPath("$.priceList").value(3));
    }

    @Test
    public void shouldApplyPriceList4_whenRequestIsForJune16thAt9AM() throws Exception{
        
        PriceRequestDto request = new PriceRequestDto();
        request.setProductId(35455L);
        request.setBrandId(1L);
        request.setApplicationDate(LocalDateTime.of(2020, 6, 16, 21, 0, 0));
        
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/prices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(38.95))
        .andExpect(jsonPath("$.priceList").value(4));
    }



    @Test
    public void shouldReturnNotFound_whenProducIdNoExist() throws Exception{

        PriceRequestDto request = new PriceRequestDto();
        request.setProductId(99999L);
        request.setBrandId(1L);
        request.setApplicationDate(LocalDateTime.of(2020, 6, 16, 21, 0, 0));
        
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/prices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnBadRequest_whenBrandIdFaultInRequest() throws Exception{

        PriceRequestDto request = new PriceRequestDto();
        request.setProductId(99999L);
      //  request.setBrandId(1L);
        request.setApplicationDate(LocalDateTime.of(2020, 6, 16, 21, 0, 0));
        
        String json = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/prices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnBadRequest_whenApplicationDateHaveWrongFormat() throws Exception{
        
        
        String json = "{\"brand_id\": 1, \"product_id\": 35455, \"application_date\": \"fecha-invalida\"}";;

        mockMvc.perform(post("/api/prices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isBadRequest());
    }
}
