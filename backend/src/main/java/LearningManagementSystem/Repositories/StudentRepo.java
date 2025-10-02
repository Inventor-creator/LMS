package LearningManagementSystem.Repositories;

import LearningManagementSystem.Model.Student;
import LearningManagementSystem.requestObjects.AllStudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student , Integer> {


    @Query(value =  " SELECT s FROM Student s WHERE s.year = :year")
    public List<Student> getStudentByYear(@Param("year") Integer year);

//    @Query(value = "SELECT s, b  , si FROM Student s , Branches b ,  StudentInfo si WHERE (si.student = s  AND s.branch = b)")
//    public List<AllStudentInfo> getAllStudents();

    @Query(value = "SELECT * FROM (SELECT * FROM student s NATURAL JOIN student_info si LEFT JOIN branches b USING (branch_id) );" , nativeQuery = true)
    public List<AllStudentInfo> getAllStudents();

}
