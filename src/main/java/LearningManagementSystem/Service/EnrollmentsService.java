package LearningManagementSystem.Service;

import LearningManagementSystem.Model.Courses;
import LearningManagementSystem.Model.EnrollmentInfo;
import LearningManagementSystem.Model.Student;
import LearningManagementSystem.Repositories.CourseRepo;
import LearningManagementSystem.Repositories.EnrollRepo;
import LearningManagementSystem.Repositories.StudentRepo;
import LearningManagementSystem.requestObjects.EnrollStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnrollmentsService {

    @Autowired
    CourseRepo cRepo;
    @Autowired
    EnrollRepo eRepo;
    @Autowired
    StudentRepo sRepo;

    public boolean enroll(EnrollStudentRequest enrollStudentRequest){

        Optional<Courses> course = cRepo.findById(enrollStudentRequest.courseId);
        Optional<Student> student = sRepo.findById(enrollStudentRequest.studentId);

        if (course.isPresent() && student.isPresent()) {

            EnrollmentInfo enrollment = new EnrollmentInfo(enrollStudentRequest.year , student.get() , course.get() , false );

            eRepo.save(enrollment);

            return true;
        }
        else {

            return false;
        }
    }

}
