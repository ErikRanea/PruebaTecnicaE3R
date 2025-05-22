package com.e3r.pruebaTecnicaErikRanea.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.e3r.pruebaTecnicaErikRanea.model.Price;
import com.e3r.pruebaTecnicaErikRanea.repository.PriceRepository;

@ExtendWith(MockitoExtension.class)
public class PriceServiceImplTest {

    @Mock
    private PriceRepository repository;

    @InjectMocks
    private PriceServiceImpl service;

    @Test
    void findAll_shouldReturnListOfPrices(){

        LocalDateTime now = LocalDateTime.now();

        Price price1 = new Price(null,1L, now.minusDays(1), now.plusDays(1), 1, 101L, 0, 25.50, "EUR");
        Price price2 = new Price(null,2L, now.minusDays(2), now.plusDays(2), 2, 102L, 1, 35.50, "EUR");

        List<Price> expectedPrices = Arrays.asList(price1,price2);

        when(repository.findAll()).thenReturn(expectedPrices);

        List<Price> actualPrices = service.findAll();

        assertNotNull(actualPrices);
        assertEquals(2, actualPrices.size());
        assertEquals(expectedPrices, actualPrices);
        verify(repository).findAll();

    }

    @Test
    void findAll_whenNoPricesExist_shouldReturnEmptyList(){

        when(repository.findAll()).thenReturn(Collections.emptyList());

        List<Price> actualPrices = service.findAll();

        assertNotNull(actualPrices);
        assertTrue(actualPrices.isEmpty());
        verify(repository).findAll();

    }

    @Test
    void searchPrice_whenPriceExistsInRepository_shouldReturnOptionalWithPrice(){

        Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime date = LocalDateTime.now();
        Price foundPrice = new Price(1L,1L,date.minusDays(1),date.plusDays(2),1,35455L,1,25.55,"EUR");

        when(repository.searchPrice(brandId, productId, date)).thenReturn(Optional.of(foundPrice));

        Optional<Price> actualResult = service.searchPrice(brandId, productId, date);

        assertNotNull(actualResult);
        assertEquals(foundPrice, actualResult.get());
        verify(repository).searchPrice(brandId, productId, date);

    }

    @Test
    void searchPrice_whenPriceNoExistsInRepository_shouldReturnOptionalWithNull(){
        
        Long brandId = 45L;
        Long productId = 3L;
        LocalDateTime date = LocalDateTime.now();


        when(repository.searchPrice(brandId, productId, date)).thenReturn(Optional.ofNullable(null));

        Optional<Price> actualReturn = service.searchPrice(brandId, productId, date);

        assertNotNull(actualReturn);
        assertEquals(Optional.ofNullable(null), actualReturn);
        verify(repository).searchPrice(brandId, productId, date);
    }
    

}
