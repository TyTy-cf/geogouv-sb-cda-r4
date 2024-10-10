package fr.kevin.exam.service;

import fr.kevin.exam.DTO.CityDTO;
import fr.kevin.exam.entity.City;
import fr.kevin.exam.repository.CityRepository;
import fr.kevin.exam.service.interfaces.PageableServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CityService implements
        PageableServiceInterface<CityDTO> {

    private CityRepository cityRepository;

    @Override
    public Page<CityDTO> list(Pageable pageable) {
        Page<City> cities = cityRepository.findAll(pageable);
        List<CityDTO> cityDTOS = new ArrayList<>();
        cities.forEach(city -> {
            List<String> postalCodes = new ArrayList<>();
            city.getPostalCodes().forEach(pc -> {
                postalCodes.add(pc.getCode());
            });
            cityDTOS.add(
                new CityDTO(
                    city.getId(),
                    city.getName(),
                    city.getCode(),
                    city.getSiren(),
                    city.getPopulation(),
                    postalCodes
                )
            );
        });
        return new PageImpl<>(cityDTOS, pageable, cities.getTotalElements());
    }
}
