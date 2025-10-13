package LearningManagementSystem.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//only admins can add students,
//admin access lvl 1 => adding students only ( manually or through csv imports in the future i hope )


@Entity
@Table(name = "Admins")
public class Admins {

    @Id
    @Column(name = "adminId")
    private Integer adminId;

    @Column(name = "adminName")
    private String adminName;

    @Column(name = "accessLvl")
    private Integer accessLvl;

    public Admins(Integer adminId, String adminName, Integer accessLvl) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.accessLvl = accessLvl;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getAccessLvl() {
        return accessLvl;
    }

    public void setAccessLvl(Integer accessLvl) {
        this.accessLvl = accessLvl;
    }
}
