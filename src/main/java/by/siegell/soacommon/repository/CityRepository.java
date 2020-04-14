package by.siegell.soacommon.repository;

import by.siegell.soacommon.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
    List<City> findByName(String name);
}
