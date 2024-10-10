package fr.kevin.exam.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CityDTO {

    private Integer id;

    private String name;

    private String code;

    private String siren;

    private int population;

    private List<String> postalCodes = new ArrayList<>();

}