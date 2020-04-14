package by.siegell.soacommon.controller;

import by.siegell.soacommon.domain.City;
import by.siegell.soacommon.domain.exception.EntityNotFoundException;
import by.siegell.soacommon.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/city")
@AllArgsConstructor
public class CityController {
    private CityService cityService;

    @PostMapping("/")
    public City createCity(@RequestBody String name) {

        return cityService.save(new City(name));
    }

    @GetMapping("/")
    public List<City> getCityAll() {
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable UUID id) throws EntityNotFoundException {
        return cityService.getById(id);
    }

    @GetMapping("/{name}")
    public List<City> getCitiesByName(@PathVariable String name) {
        return cityService.findByName(name);
    }

    @PutMapping("/")
    public City updateCity(@RequestBody City city) {
        return cityService.save(city);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable UUID id) {
        cityService.deleteById(id);
    }
}
