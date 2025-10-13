package LearningManagementSystem.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Flags")
public class Flags {

    @Id
    @Column(name = "flagId")
    private Integer flagId;

    @Column(name = "isEnrollment")
    private Boolean isEnrollment;

    @Column(name = "adminEdit")
    private Boolean isEditing;


    public Integer getFlagId() {
        return flagId;
    }

    public void setFlagId(Integer flagId) {
        this.flagId = flagId;
    }

    public Boolean getEnrollment() {
        return isEnrollment;
    }

    public void setEnrollment(Boolean enrollment) {
        isEnrollment = enrollment;
    }

    public Boolean getEditing() {
        return isEditing;
    }

    public void setEditing(Boolean editing) {
        isEditing = editing;
    }

}
