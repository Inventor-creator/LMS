package LearningManagementSystem.Service;

import LearningManagementSystem.Model.Student;
import LearningManagementSystem.Model.StudentInfo;
import LearningManagementSystem.Repositories.StudentInfoRepo;
import LearningManagementSystem.Repositories.StudentRepo;
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
    public Optional<Student> getUserService(Integer userId){
        return sRepo.findById(userId);
    }

    public String createStudentService(RequestStudent student){

        Student stu = new Student(student.year);
        sRepo.save(stu);
        StudentInfo stuInfo = new StudentInfo( stu ,student.address , student.number , student.email , student.studentName);

        sInfoRepo.save(stuInfo);

        return "User created successfully";
    }

    public List<Student> getAll(){
        return sRepo.findAll();
    }

    public List<Student> getByYear(Integer year){
        return sRepo.getStudentByYear(year);
    }

}
