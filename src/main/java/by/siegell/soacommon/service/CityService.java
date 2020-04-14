package by.siegell.soacommon.service;

import by.siegell.soacommon.domain.City;
import by.siegell.soacommon.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CityService extends EntityCRUDService<City, UUID, CityRepository> {

    private CityRepository repository;

    @Override
    CityRepository getRepository() {
        return repository;
    }

    public List<City> findByName(String name) {
        return repository.findByName(name);
    }
}
