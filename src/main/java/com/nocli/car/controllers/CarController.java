package com.nocli.car.controllers;

import com.nocli.car.Car;
import com.nocli.car.services.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("{regNumber}")
    public Car getCarByRegNumber(@PathVariable("regNumber") String regNumber) {
        return carService.getCarByRegNumber(regNumber);
    }
}
