package LearningManagementSystem.Service;

import LearningManagementSystem.Model.*;
import LearningManagementSystem.Repositories.BranchRepo;
import LearningManagementSystem.Repositories.StudentInfoRepo;
import LearningManagementSystem.Repositories.StudentPassRepo;
import LearningManagementSystem.Repositories.StudentRepo;
import LearningManagementSystem.requestObjects.Access;
import LearningManagementSystem.requestObjects.AllStudentInfo;
import LearningManagementSystem.requestObjects.RequestStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo sRepo;
    @Autowired
    StudentInfoRepo sInfoRepo;
    @Autowired
    BranchRepo bRepo;
    @Autowired
    StudentPassRepo sPassRepo;

    public Optional<Student> getUserService(Integer userId){
        return sRepo.findById(userId);
    }

    public String createStudentService(RequestStudent student){
        Student stu = new Student(student.year, bRepo.getReferenceById(student.branchId));

        sRepo.save(stu);
        StudentInfo stuInfo = new StudentInfo( stu ,student.address , student.number , student.email , student.studentName);
        sInfoRepo.save(stuInfo);
        StudentPasses studentPass = new StudentPasses(stu , stuInfo , "default");
        sPassRepo.save(studentPass);
        return "User created successfully";
    }

    public List<AllStudentInfo> getAll(){

        return sRepo.getAllStudents();
    }

    public List<Student> getByYear(Integer year){
        return sRepo.getStudentByYear(year);
    }


}
