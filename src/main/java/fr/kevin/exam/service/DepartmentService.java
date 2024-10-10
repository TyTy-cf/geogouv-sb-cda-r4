package fr.kevin.exam.service;

import fr.kevin.exam.DTO.CityDTO;
import fr.kevin.exam.DTO.DepartmentCityDTO;
import fr.kevin.exam.DTO.DepartmentDTO;
import fr.kevin.exam.entity.Department;
import fr.kevin.exam.repository.DepartmentRepository;
import fr.kevin.exam.service.interfaces.PageableServiceInterface;
import fr.kevin.exam.service.interfaces.SlugServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService implements
        PageableServiceInterface<DepartmentDTO>,
        SlugServiceInterface<Department> {

    private DepartmentRepository departmentRepository;

    @Override
    public Page<DepartmentDTO> list(Pageable pageable) {
        Page<Department> departments = departmentRepository.findAll(pageable);
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        departments.forEach(d -> {
            departmentDTOS.add(getDTOByObject(d));
        });
        return new PageImpl<>(departmentDTOS, pageable, departments.getTotalElements());
    }

    @Override
    public Department findBySlug(String slug) {
        return departmentRepository.findBySlug(slug)
                .orElseThrow(EntityNotFoundException::new);
    }

    public DepartmentDTO getDTOBySlug(String slug) {
        return getDTOByObject(findBySlug(slug));
    }

    private DepartmentDTO getDTOByObject(Department d) {
        return new DepartmentDTO(
            d.getName(),
            d.getCode(),
            d.getSlug(),
            d.getCities().size()
        );
    }

    public DepartmentCityDTO findBySlugWithCities(String slug) {
        Department department = findBySlug(slug);
        DepartmentCityDTO dto = new DepartmentCityDTO();
        dto.setName(department.getName());
        dto.setSlug(department.getSlug());
        dto.setCode(department.getCode());
        List<CityDTO> cityDTOs = new ArrayList<>();
        department.getCities().forEach(city -> {
            List<String> postalCodes = new ArrayList<>();
            city.getPostalCodes().forEach(pc -> {
                postalCodes.add(pc.getCode());
            });
            cityDTOs.add(
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
        dto.setCities(cityDTOs);
        return dto;
    }

    public List<DepartmentDTO> findDepartmentsWithMostCities() {
        List<Department> departments = departmentRepository.findDepartmentsWithMostCities();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        departments.forEach(d -> {
            departmentDTOS.add(getDTOByObject(d));
        });
        return departmentDTOS;
    }
}
