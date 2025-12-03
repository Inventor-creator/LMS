package LearningManagementSystem.Service;

import LearningManagementSystem.Component.JwtUtil;
import LearningManagementSystem.Model.AdminPasses;
import LearningManagementSystem.Model.Admins;
import LearningManagementSystem.Model.StudentPasses;
import LearningManagementSystem.Repositories.AdminPassRepo;
import LearningManagementSystem.Repositories.AdminRepo;
import LearningManagementSystem.Repositories.StudentPassRepo;
import LearningManagementSystem.Repositories.StudentRepo;
import LearningManagementSystem.requestObjects.Access;
import LearningManagementSystem.requestObjects.AllAdminInfo;
import LearningManagementSystem.requestObjects.AllStudentInfo;
import LearningManagementSystem.requestObjects.LoginInfo;

import jakarta.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Auth {
    @Autowired
    StudentPassRepo studentPassRepo;
    @Autowired
    AdminPassRepo adPassRepo;
    @Autowired
    StudentRepo sRepo;

    @Autowired
    AdminRepo aRepo;

    //create another method for checking instructor credentials
    public Optional<StudentPasses> checkStuCredentials(LoginInfo loginInfo){

        String mail = loginInfo.getEmail();
        String password = loginInfo.getPassword();


        return studentPassRepo.lookForPass(mail , password);
    }

    public Optional<AdminPasses> checkAdminCredentials(LoginInfo loginInfo){

        String mail = loginInfo.getEmail();
        String password = loginInfo.getPassword();

        return adPassRepo.checkMailPass(mail , password);


    }

    @Autowired
    JwtUtil jwtUtil;
    public Cookie getAuthCookie(Access userDeets , String mail){

        Cookie myCookie = new Cookie("token", jwtUtil.generateToken(userDeets , mail));

        myCookie.setMaxAge(60000); // 24 hours in seconds
        myCookie.setPath("/"); // Available for all paths
        myCookie.setHttpOnly(true); // Prevents client-side script access

        return myCookie;
    }

    public Boolean validateCookie(Cookie cookie , Access access){


        return jwtUtil.validateToken(cookie.getValue() , access.getName() , access.getId() );

    }

    public Access getAccess(String email) {
        Optional<AllStudentInfo> temp = sRepo.getIdNameByMail(email);


        if (temp.isEmpty()) {
            Optional<AllAdminInfo> temp2 = aRepo.getAdminInfo(email);

            if(temp2.isPresent()){
                AllAdminInfo adminInfo = temp2.get();
                return new Access(email, "admin", adminInfo.getAdminId(), adminInfo.getAdminName() , adminInfo.getAccessLvl());
            }
            return new Access();
        }


        return new Access(email, "student", temp.get().getStudentId(), temp.get().getStudentName());
    }
}
