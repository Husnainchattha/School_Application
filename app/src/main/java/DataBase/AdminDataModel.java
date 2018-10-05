package DataBase;

import java.io.Serializable;

public class AdminDataModel implements Serializable {
    public String adminname;
    public String adminpassword;

    public AdminDataModel() {

    }

    public String getAdminname() {

        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }

    public AdminDataModel(String adminname, String adminpassword) {

        this.adminname = adminname;
        this.adminpassword = adminpassword;
    }
}
