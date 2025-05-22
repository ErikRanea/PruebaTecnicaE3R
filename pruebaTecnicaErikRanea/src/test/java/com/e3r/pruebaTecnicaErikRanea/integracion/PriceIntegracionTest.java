package com.e3r.pruebaTecnicaErikRanea.integracion;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.e3r.pruebaTecnicaErikRanea.dtos.PricePeticionDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceIntegracionTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private  ObjectMapper objectMapper;

    @Test
    public void test1() throws Exception{
        PricePeticionDto peticion = new PricePeticionDto();
        peticion.setProductId(35455L);
        peticion.setBrandId(1L);
        peticion.setFechaDeAplicacion(LocalDateTime.of(2020, 6, 14, 10, 0, 0));
        
        String json = objectMapper.writeValueAsString(peticion);

        mockMvc.perform(post("/api/prices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.precio_final").value(35.50))
        .andExpect(jsonPath("$.price_list").value(1));


    }

    @Test
    public void test2() throws Exception{
         PricePeticionDto peticion = new PricePeticionDto();
        peticion.setProductId(35455L);
        peticion.setBrandId(1L);
        peticion.setFechaDeAplicacion(LocalDateTime.of(2020, 6, 14, 16, 0, 0));
        
        String json = objectMapper.writeValueAsString(peticion);

        mockMvc.perform(post("/api/prices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.precio_final").value(25.45))
        .andExpect(jsonPath("$.price_list").value(2));
    }

    @Test
    public void test3() throws Exception{
         PricePeticionDto peticion = new PricePeticionDto();
        peticion.setProductId(35455L);
        peticion.setBrandId(1L);
        peticion.setFechaDeAplicacion(LocalDateTime.of(2020, 6, 14, 21, 0, 0));
        
        String json = objectMapper.writeValueAsString(peticion);

        mockMvc.perform(post("/api/prices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.precio_final").value(35.5))
        .andExpect(jsonPath("$.price_list").value(1));
    }

    @Test
    public void test4() throws Exception{
         PricePeticionDto peticion = new PricePeticionDto();
        peticion.setProductId(35455L);
        peticion.setBrandId(1L);
        peticion.setFechaDeAplicacion(LocalDateTime.of(2020, 6, 15, 10, 0, 0));
        
        String json = objectMapper.writeValueAsString(peticion);

        mockMvc.perform(post("/api/prices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.precio_final").value(30.50))
        .andExpect(jsonPath("$.price_list").value(3));
    }

    @Test
    public void test5() throws Exception{
         PricePeticionDto peticion = new PricePeticionDto();
        peticion.setProductId(35455L);
        peticion.setBrandId(1L);
        peticion.setFechaDeAplicacion(LocalDateTime.of(2020, 6, 16, 21, 0, 0));
        
        String json = objectMapper.writeValueAsString(peticion);

        mockMvc.perform(post("/api/prices")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.precio_final").value(38.95))
        .andExpect(jsonPath("$.price_list").value(4));
    }
}
