package fr.kevin.exam.repository;

import fr.kevin.exam.entity.Department;
import fr.kevin.exam.repository.interfaces.EntitySlugRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>,
                                              EntitySlugRepository<Department> {

    @Query("SELECT d FROM Department d JOIN City c ON c.department.id = d.id GROUP BY d.id ORDER BY COUNT(c.id) DESC LIMIT 5")
    List<Department> findDepartmentsWithMostCities();

}