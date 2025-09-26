package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.Courses;
import LearningManagementSystem.Model.EnrollmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CourseRepo extends JpaRepository<Courses, Integer> {

    @Query(value = "SELECT c FROM Courses c WHERE courseName = :name")
    Optional<Courses> findByName(@Param("name") String Name);
}
