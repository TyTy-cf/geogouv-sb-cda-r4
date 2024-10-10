package fr.kevin.exam.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.kevin.exam.entity.Region;
import fr.kevin.exam.json_views.JsonViews;
import fr.kevin.exam.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/region")
public class RegionRestController {

    private RegionService regionService;

    @GetMapping
    @JsonView(JsonViews.RegionListView.class)
    public List<Region> list() {
        return regionService.list();
    }

    @GetMapping("/{slug}")
    @JsonView(JsonViews.RegionListView.class)
    public Region getBySlug(@PathVariable String slug) {
        return regionService.findBySlug(slug);
    }

    @GetMapping("/{slug}/department")
    @JsonView(JsonViews.RegionShowView.class)
    public Region regionDepartment(@PathVariable String slug) {
        return regionService.findBySlug(slug);
    }

}
