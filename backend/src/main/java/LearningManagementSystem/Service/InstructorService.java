package LearningManagementSystem.Service;

import LearningManagementSystem.Model.Instructors;
import LearningManagementSystem.Repositories.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    InstructorRepo iRepo;

    public Boolean createInstructor(Instructors instructor){
        try {
            iRepo.save(instructor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
