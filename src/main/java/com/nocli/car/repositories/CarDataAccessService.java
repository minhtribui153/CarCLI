package com.nocli.car.repositories;

import com.nocli.car.Car;
import com.nocli.car.interfaces.CarDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarDataAccessService implements CarDao {
    private final List<Car> cars;

    public CarDataAccessService() { cars = new ArrayList<>(); }

    @Override
    public Optional<Car> selectCarByRegNumber(String regNumber) {
        return cars.stream()
                .filter(c -> c.getRegNumber().equals(regNumber))
                .findFirst();
    }

    @Override
    public List<Car> selectAllCars() {
        return cars;
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }
}
