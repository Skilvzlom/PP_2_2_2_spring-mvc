package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {
    public List<Car> getAllCars() {
        return Arrays.asList(
                new Car("Oka", 2004, "Monte carlo"),
                new Car("Tesla model 5", 2017, "White"),
                new Car("Range rover", 2020, "Black"),
                new Car("VAZ 2114", 2008, "Black"),
                new Car("VAZ 2115", 2010, "White")

        );
    }

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(name = "count", required = false, defaultValue = "5") int count, Model model) {
        List<Car> allCars = getAllCars();
        List<Car> subCar = allCars.subList(0, Math.min(count, allCars.size()));
        model.addAttribute("cars", subCar);
        return "cars";
    }
}
