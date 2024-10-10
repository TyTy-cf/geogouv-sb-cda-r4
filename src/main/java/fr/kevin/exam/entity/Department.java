package fr.kevin.exam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.kevin.exam.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.DepartmentListView.class)
    private Integer id;

    @JsonView({JsonViews.DepartmentListView.class, JsonViews.RegionShowView.class})
    private String name;

    @JsonView({JsonViews.DepartmentListView.class, JsonViews.RegionShowView.class})
    private String code;

    @JsonView({JsonViews.DepartmentListView.class,  JsonViews.RegionShowView.class})
    private String slug;

    @ManyToOne
    @JsonView(JsonViews.DepartmentShowView.class)
    private Region region;

    @OneToMany(mappedBy = "department")
    private List<City> cities = new ArrayList<>();

}