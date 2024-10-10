package fr.kevin.exam.controller_api;

import fr.kevin.exam.DTO.CityDTO;
import fr.kevin.exam.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/city")
public class CityRestController {

    private CityService cityService;

    @GetMapping
    public Page<CityDTO> list(
        @PageableDefault(
            size = 15
        ) Pageable pageable
    ) {
        return cityService.list(pageable);
    }

}