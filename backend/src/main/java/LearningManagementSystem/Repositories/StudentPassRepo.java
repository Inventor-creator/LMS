package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.StudentPasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentPassRepo extends JpaRepository<StudentPasses , Integer> {

    @Query(value = "SELECT s FROM StudentPasses s WHERE s.studentInfo.email = :email AND s.password = :password")
    Optional<StudentPasses> lookForPass(@Param("email") String email , @Param("password") String password);
}

