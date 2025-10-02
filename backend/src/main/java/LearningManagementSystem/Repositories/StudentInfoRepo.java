package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInfoRepo extends JpaRepository<StudentInfo , Integer> {
}
