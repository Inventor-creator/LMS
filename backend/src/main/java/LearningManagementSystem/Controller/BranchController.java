package LearningManagementSystem.Controller;

import LearningManagementSystem.Model.Branches;
import LearningManagementSystem.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true" , origins = "http://localhost:5173")
public class BranchController {

    @Autowired
    BranchService branchService;

    @PostMapping("/createBranch")
    public String CreateBranch(@RequestBody Branches branch){

        if(branchService.createBranch(branch)){
            return "Branch Created Successfully";
        }else{
            return "Something went wrong";
        }

    }

    //create one for delete too


    @GetMapping("/searchBranches/{similarBranch}")
    public List<Branches> getSimilarBranches(@PathVariable("similarBranch") String similarBranch){
        return branchService.getSimilarBranches(similarBranch);
    }

}
