package LearningManagementSystem.requestObjects;

public class RequestStudent {

        public int year;
        public String address;
        public String number;
        public String email;
        public String studentName;
        public String BranchName;

    public RequestStudent(int year, String address, String number, String email, String studentName, String branchName) {
        this.year = year;
        this.address = address;
        this.number = number;
        this.email = email;
        this.studentName = studentName;
        this.BranchName = branchName;
    }

}
