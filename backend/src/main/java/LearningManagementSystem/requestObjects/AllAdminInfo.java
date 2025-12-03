package LearningManagementSystem.requestObjects;

public class AllAdminInfo {
    private Integer adminId= -1;
    private String adminName= "";
    private String adminPass;
    private Integer accessLvl;

    public AllAdminInfo(){}


    //part of the thing i need, too lazy to create new obj
    public AllAdminInfo(Integer adminId , String adminName){
        this.adminId = adminId;
        this.adminName = adminName;
    }

    public AllAdminInfo(Integer adminId,  String adminName, String adminPass, Integer accessLvl) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPass = adminPass;
        this.accessLvl = accessLvl;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public Integer getAccessLvl() {
        return accessLvl;
    }

    public void setAccessLvl(Integer accessLvl) {
        this.accessLvl = accessLvl;
    }
}
