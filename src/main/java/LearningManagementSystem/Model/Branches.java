package LearningManagementSystem.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Branches")
public class Branches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId;

    private String branchName;



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
