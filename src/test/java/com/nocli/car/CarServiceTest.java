package com.nocli.car;

import com.nocli.car.repositories.CarDataAccessService;
import com.nocli.car.services.CarService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class CarServiceTest {
    CarDataAccessService carDataAccessService = new CarDataAccessService();
    CarService carService = new CarService(carDataAccessService);
    Car vinfastCar = new Car("Vinfast VF8", new BigDecimal("90"), "SBB2354G", true);

    @Test
    @DisplayName("Can register cars from CSV File")
    void canRegisterCarsFromCSVFile() {
        assertEquals(7, carService.getAllCars().size());
        carService.getAllCars().forEach(System.out::println);
    }

    @Test
    @DisplayName("Can show normal cars")
    void canShowNormalCars() {
        assertEquals(3, carService.getAllNormalCars().size());
        carService.getAllNormalCars().forEach(System.out::println);
    }

    @Test
    @DisplayName("Can show electric cars")
    void canShowElectricCars() {
        assertEquals(4, carService.getAllElectricCars().size());
        carService.getAllElectricCars().forEach(System.out::println);
    }

    @Test
    @DisplayName("Can find cars by register number")
    void canFindCarsByRegNum() {
        assertEquals(vinfastCar, carService.getCarByRegNumber(vinfastCar.getRegNumber()));
        System.out.println(carService.getCarByRegNumber(vinfastCar.getRegNumber()));
    }


}
