package LearningManagementSystem.Service;

import LearningManagementSystem.Model.Courses;
import LearningManagementSystem.Model.Instructors;
import LearningManagementSystem.Model.Student;
import LearningManagementSystem.Repositories.InstructorRepo;
import LearningManagementSystem.Repositories.StudentRepo;
import LearningManagementSystem.requestObjects.createCourseReq;
import LearningManagementSystem.Repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepo cRepo;
    @Autowired
    InstructorRepo iRepo;
    @Autowired
    StudentRepo sRepo;

    //create a course request object
    public boolean createRepo(createCourseReq course){

        if(cRepo.findByName(course.getCourseName() , course.getInstructorId()).isPresent()){
            return false;
        }
        else{
            Optional<Instructors> instructor = iRepo.findById(course.getInstructorId());
            Courses nCourse = new Courses(course.getCourseName() , instructor.get() , course.getEnrollmentYear());

            cRepo.save(nCourse);

            return true;
        }
    }


    public List<Courses> getByYear(Integer studentId){
        Optional<Student> student = sRepo.findById(studentId);
        if(student.isPresent()){
            return cRepo.getCoursesByYear(student.get().getYear());

        }
        else{
            return null;
        }
    }

    public List<Courses> getAll(){
        return  cRepo.findAll();
    }

}
