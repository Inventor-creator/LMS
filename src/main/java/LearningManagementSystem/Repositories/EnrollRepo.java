package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.EnrollmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrollRepo extends JpaRepository<EnrollmentInfo , Integer> {

    @Query(value = "SELECT e FROM EnrollmentInfo e WHERE course.courseId = :courseId")
    public List<EnrollmentInfo> getByCourseId(@Param("courseId") Integer courseId);

    @Query(value = "SELECT e FROM EnrollmentInfo e WHERE student.studentId = :studentId AND status = :active")
    public List<EnrollmentInfo> getByStudentIdAndActive(@Param("studentId") Integer studentId , @Param("active") Boolean active);
}
