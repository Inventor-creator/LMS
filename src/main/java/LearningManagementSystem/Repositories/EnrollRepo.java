package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.EnrollmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollRepo extends JpaRepository<EnrollmentInfo , Integer> {

}
