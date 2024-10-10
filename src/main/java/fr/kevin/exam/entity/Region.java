package fr.kevin.exam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.kevin.exam.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(JsonViews.RegionMinimalView.class)
    private String name;

    @JsonView(JsonViews.RegionMinimalView.class)
    private String code;

    @JsonView(JsonViews.RegionMinimalView.class)
    private String slug;

    @OneToMany(mappedBy = "region")
    @JsonView(JsonViews.RegionShowView.class)
    private List<Department> departments = new ArrayList<>();

    @JsonView(JsonViews.RegionListView.class)
    public int departmentCount() {
        return departments.size();
    }

}