package fr.kevin.exam.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepartmentCityDTO {

    private String name;

    private String code;

    private String slug;

    private List<CityDTO> cities = new ArrayList<>();

}