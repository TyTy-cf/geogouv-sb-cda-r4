package fr.kevin.exam.repository;

import fr.kevin.exam.entity.Region;
import fr.kevin.exam.repository.interfaces.EntitySlugRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer>,
                                          EntitySlugRepository<Region> {

}