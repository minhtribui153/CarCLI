package com.nocli.car;

import com.nocli.car.repositories.CarDataAccessService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class CarDataAccessServiceTest {
    CarDataAccessService carDataAccessService = new CarDataAccessService();
    Car normalCar = new Car("Normal Car", new BigDecimal("20"), "NC2515A", false);
    Car electricCar = new Car("Electric Car", new BigDecimal("40"), "NCC124G", true);
    @Test
    @DisplayName("Can add a Car")
    void canAddACar() {
        carDataAccessService.addCar(normalCar);
        assertTrue(carDataAccessService
                .selectAllCars()
                .stream()
                .anyMatch(c -> c.equals(normalCar))
        );
    }

    @Test
    @DisplayName("Cannot add null Car")
    void cannotAddNullCar() {
        Exception e = assertThrows(NullPointerException.class, () -> carDataAccessService.addCar(null));
        assertEquals("Car cannot be null", e.getMessage());
    }

    @Test
    @DisplayName("Cannot add Car with repetition")
    void cannotAddCarWithRepetition() {
        carDataAccessService.addCar(normalCar);
        carDataAccessService.addCar(normalCar);
        carDataAccessService.addCar(normalCar);
        assertEquals(1, carDataAccessService.selectAllCars().size());
    }
}
