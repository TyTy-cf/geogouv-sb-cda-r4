package fr.kevin.exam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String siren;

    private String name;

    private String code;

    private int population;

    private String slug;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "city")
    private List<PostalCode> postalCodes = new ArrayList<>();

}