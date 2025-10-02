package LearningManagementSystem.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Branches")
public class Branches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branchId")
    private int branchId;

    @Column(name = "branchName")
    private String branchName;

    public Branches(String branchName) {
        this.branchName = branchName;
    }

    public Branches(){

    }
    public int getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
