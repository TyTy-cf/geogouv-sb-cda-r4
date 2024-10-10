package fr.kevin.exam.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepartmentDTO {

    private String name;

    private String code;

    private String slug;

    private int citiesCount;

}