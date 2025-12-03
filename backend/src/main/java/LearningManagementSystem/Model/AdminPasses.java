package LearningManagementSystem.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "adminPasses")
public class AdminPasses {

    @Id
    private Integer adminId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "adminId" , referencedColumnName = "adminId")
    private Admins admin;


    @Column(name = "adminMail")
    private String adminMail;

    @Column(name = "adminPass")
    private String adminPass;

    public AdminPasses(){}

    public AdminPasses(Integer adminId, String adminMail, String adminPass) {
        this.adminId = adminId;

        this.adminMail = adminMail;
        this.adminPass = adminPass;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminMail() {
        return adminMail;
    }

    public void setAdminMail(String adminMail) {
        this.adminMail = adminMail;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }
}
