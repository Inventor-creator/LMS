package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.Branches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BranchRepo extends JpaRepository<Branches , Integer> {

    @Query(value = "SELECT b FROM Branches b WHERE branchName = :branchName")
    public Optional<Branches> getBranchByName(@Param("branchName") String bName);



}
