package fr.kevin.exam.repository;

import fr.kevin.exam.entity.City;
import fr.kevin.exam.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findTop10ByOrderByPopulationDesc();

}