package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;


@Service
public class CarServiceImp implements CarService {

    @Override
    public List<Car> getAllCars() {
        return Arrays.asList(
                new Car("Oka", 2004, "Monte carlo"),
                new Car("Tesla model 5", 2017, "White"),
                new Car("Range rover", 2020, "Black"),
                new Car("VAZ 2114", 2006, "Black"),
                new Car("VAZ 2115", 2010, "White")

        );
    }

    @Override
    public List<Car> getSubCars(int count) {
        List<Car> allCars = getAllCars();
        return allCars.subList(0, Math.min(count, allCars.size()));
    }
}
