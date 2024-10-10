package fr.kevin.exam.controller_api;

import fr.kevin.exam.DTO.DepartmentCityDTO;
import fr.kevin.exam.DTO.DepartmentDTO;
import fr.kevin.exam.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/department")
public class DepartmentRestController {

    private DepartmentService departmentService;

    @GetMapping
    public Page<DepartmentDTO> list(
        @PageableDefault(
            size = 15
        ) Pageable pageable
    ) {
        return departmentService.list(pageable);
    }

    @GetMapping("/{slug}")
    public DepartmentDTO show(@PathVariable String slug) {
        return departmentService.getDTOBySlug(slug);
    }

    @GetMapping("/{slug}/city")
    public DepartmentCityDTO showCity(@PathVariable String slug) {
        return departmentService.findBySlugWithCities(slug);
    }

    @GetMapping("/cities")
    public List<DepartmentDTO> departmentsWithMostCities() {
        return departmentService.findDepartmentsWithMostCities();
    }

}