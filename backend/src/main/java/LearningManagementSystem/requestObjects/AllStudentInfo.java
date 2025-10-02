package LearningManagementSystem.requestObjects;

import LearningManagementSystem.Model.Branches;
import LearningManagementSystem.Model.Student;
import LearningManagementSystem.Model.StudentInfo;
import jakarta.persistence.Column;

public class AllStudentInfo {
    public Integer studentId= -1;
    public Integer year = -1;
    public Integer branchId = -1;
    public String branchName = "";
    public String address= "";
    public String number= "";
    public String email= "";
    public String studentName= "";
//    public StudentInfo studentInfo;

    public AllStudentInfo(Integer branchId, Integer studentId, Integer year, String address, String email, String number, String studentName, String branchName) {

        this.studentId = studentId;
        this.year = year;

        this.address = address;
        this.number = number;
        this.email = email;
        this.studentName = studentName;

        this.branchId = branchId;
        this.branchName = branchName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
