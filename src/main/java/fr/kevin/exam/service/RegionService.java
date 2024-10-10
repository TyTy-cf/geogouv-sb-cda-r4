package fr.kevin.exam.service;

import fr.kevin.exam.entity.Region;
import fr.kevin.exam.repository.RegionRepository;
import fr.kevin.exam.service.interfaces.ListServiceInterface;
import fr.kevin.exam.service.interfaces.SlugServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegionService implements
        ListServiceInterface<Region>,
        SlugServiceInterface<Region> {

    private RegionRepository regionRepository;

    @Override
    public List<Region> list() {
        return regionRepository.findAll();
    }

    @Override
    public Region findBySlug(String slug) {
        return regionRepository.findBySlug(slug)
                .orElseThrow(EntityNotFoundException::new);
    }

}
