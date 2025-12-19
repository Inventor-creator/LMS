package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.Admins;
import LearningManagementSystem.requestObjects.AllAdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admins, Integer> {

    @Query(value = "SELECT admin_id,admin_name,admin_pass,access_lvl FROM admins a NATURAL JOIN admin_passes ap WHERE admin_mail = :adMail" , nativeQuery = true)
    public Optional<AllAdminInfo> getAdminInfo(@Param("adMail") String adMail);


}
