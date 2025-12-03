package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.AdminPasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface AdminPassRepo extends JpaRepository<AdminPasses , Integer> {
    @Query(value = "SELECT a from AdminPasses a WHERE adminMail = :mail AND adminPass = :password ")
    public Optional<AdminPasses> checkMailPass(@PathVariable("mail") String mail , @PathVariable("password") String password);
}
