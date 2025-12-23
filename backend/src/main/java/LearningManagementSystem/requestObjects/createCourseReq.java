package LearningManagementSystem.requestObjects;


public class createCourseReq {

    public String courseName;
    public Integer instructorId;
    public Integer enrollmentYear;
    public Integer branchId;

    public createCourseReq(String courseName, Integer instructorId, Integer enrollmentYear, Integer branchId) {
        this.courseName = courseName;
        this.instructorId = instructorId;
        this.enrollmentYear = enrollmentYear;
        this.branchId = branchId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public Integer getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(Integer enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }
}
