package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.Flags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface FlagsRepo extends JpaRepository<Flags , Integer> {

    @Query(value = "SELECT f FROM Flags f WHERE isEditing")
    public Optional<Flags> isEditing();

    @Query(value = "SELECT f FROM Flags f WHERE isEnrollment")
    public Optional<Flags> isEnrolling();
}
