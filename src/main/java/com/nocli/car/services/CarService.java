package com.nocli.car.services;

import com.nocli.car.Car;
import com.nocli.car.interfaces.CarDao;
import com.nocli.exception.ResourceNotFoundException;
import com.nocli.utils.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.*;

@Service
public class CarService {
    private CarDao carDao;

    public CarService(CarDao carDao) {
        this.carDao = carDao;
        this.registerCarsFromCSV();
    }

    private void registerCarsFromCSV() {
        Optional.ofNullable(getClass().getClassLoader().getResource("cars.csv"))
            .map(URL::getPath)
            .map(File::new)
            .filter(File::exists)
            .map(FileUtils::readFile)
            .ifPresent(data -> Arrays.stream(data)
                .map(d -> d.split(","))
                .skip(1)
                .map(carData -> new Car(carData[0], new BigDecimal(carData[2]), carData[1], carData[3].equals("true")))
                .forEach(carDao::addCar));
    }

    public void registerNewCar(Car car) {
        carDao.addCar(car);
    }

    public List<Car> getAllCars() {
        return carDao.selectAllCars();
    }

    public List<Car> getAllNormalCars() { return carDao.selectAllNormalCars(); }

    public Car getCarByRegNumber(String regNumber) {
        return carDao.selectCarByRegNumber(regNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Car with registration number [%s] not found".formatted(regNumber)));
    }


    public List<Car> getAllElectricCars() {
        return carDao.selectAllElectricCars();
    }
}
