package com.nocli.car.interfaces;

import com.nocli.car.Car;

import java.util.List;
import java.util.Optional;

public interface CarDao {
    List<Car> selectAllCars();
    Optional<Car> selectCarByRegNumber(String regNumber);
    void addCar(Car car);
    default List<Car> selectAllNormalCars() {
        return selectAllCars().stream().filter(car -> !car.isElectric()).toList();
    }
    default List<Car> selectAllElectricCars() {
        return selectAllCars().stream().filter(Car::isElectric).toList();
    }
}
