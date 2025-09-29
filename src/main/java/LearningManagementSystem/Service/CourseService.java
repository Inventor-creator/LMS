package LearningManagementSystem.Service;

import LearningManagementSystem.Model.Courses;
import LearningManagementSystem.Model.Instructors;
import LearningManagementSystem.Repositories.InstructorRepo;
import LearningManagementSystem.requestObjects.createCourseReq;
import LearningManagementSystem.Repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepo cRepo;
    @Autowired
    InstructorRepo iRepo;

    //create a course request object
    public boolean createRepo(createCourseReq course){

        if(cRepo.findByName(course.getCourseName() , course.getInstructorId()).isPresent()){
            return false;
        }
        else{
            Optional<Instructors> instructor = iRepo.findById(course.getInstructorId());
            Courses nCourse = new Courses(course.getCourseName() , instructor.get());
            cRepo.save(nCourse);
            return true;
        }
    }


}
