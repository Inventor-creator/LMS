package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.Courses;
import LearningManagementSystem.Model.EnrollmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CourseRepo extends JpaRepository<Courses, Integer> {

    @Query(value = "SELECT c FROM Courses c  WHERE courseName = :name AND c.instructor.instructorId =  :instructorId AND c.branch.branchId = :branchId")
    Optional<Courses> findByName(@Param("name") String Name , @Param("instructorId") Integer instructorId,@Param("branchId") Integer branchId );

    @Query(value = "SELECT c FROM Courses c WHERE enrollmentYear = :year")
    List<Courses> getCoursesByYear(@Param("year") Integer year);
}
