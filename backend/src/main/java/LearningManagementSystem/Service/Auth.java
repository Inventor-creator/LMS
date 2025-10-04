package LearningManagementSystem.Service;

import LearningManagementSystem.Model.StudentPasses;
import LearningManagementSystem.Repositories.StudentPassRepo;
import LearningManagementSystem.requestObjects.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Auth {
    @Autowired
    StudentPassRepo passRepo;

    //create another method for checking instructor credentials
    public Optional<StudentPasses> checkStuCredentials(LoginInfo loginInfo){

        String mail = loginInfo.getEmail();
        String password = loginInfo.getPassword();


        return passRepo.lookForPass(mail , password);


    }


}
