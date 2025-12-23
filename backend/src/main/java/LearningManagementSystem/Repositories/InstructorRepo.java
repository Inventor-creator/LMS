package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.Instructors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface InstructorRepo extends JpaRepository<Instructors , Integer> {

    @Query(value = "SELECT i FROM Instructors i WHERE i.instructorName LIKE CONCAT(:instructorName, '%') ORDER BY i.instructorId ASC")
    public ArrayList<Instructors> getInstructorsByName(@Param("instructorName") String insName);

}
