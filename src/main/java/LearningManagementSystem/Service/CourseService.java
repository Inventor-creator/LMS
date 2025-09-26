package LearningManagementSystem.Service;

import LearningManagementSystem.Model.Courses;
import LearningManagementSystem.Repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    CourseRepo cRepo;

    public boolean createRepo(Courses course){

        if(cRepo.findByName(course.getCourseName()).isPresent()){
            return false;
        }
        else{

            cRepo.save(course);
            return true;
        }
    }


}
