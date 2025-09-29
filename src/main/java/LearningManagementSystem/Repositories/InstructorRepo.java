package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.Instructors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructors , Integer> {
}
