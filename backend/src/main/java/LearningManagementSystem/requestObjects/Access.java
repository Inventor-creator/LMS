package LearningManagementSystem.requestObjects;

public class Access {

    public String name;
    public String role;
    public Integer id;

    public Access(){

    }

    public Access(String name, String role , Integer id) {
        this.name = name;
        this.role = role;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Access{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", id=" + id +
                '}';
    }
}
