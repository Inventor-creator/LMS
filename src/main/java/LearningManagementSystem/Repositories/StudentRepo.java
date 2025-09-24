package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student , Integer> {


    @Query(value =  " SELECT s FROM Student s WHERE s.year = :year")
    public List<Student> getStudentByYear(@Param("year") Integer year);

}
