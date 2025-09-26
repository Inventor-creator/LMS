package LearningManagementSystem.Service;

import LearningManagementSystem.Model.Branches;
import LearningManagementSystem.Repositories.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {

    @Autowired
    BranchRepo branchRepo;

    public boolean createBranch(Branches branch){
        try{
            branchRepo.save(branch);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
