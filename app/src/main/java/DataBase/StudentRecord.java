package DataBase;

import java.io.Serializable;

public class StudentRecord implements Serializable {

    private String name;
    private String fathername;
    private String rollno;
    private String address;
    private String contact;

    public StudentRecord(String name, String fathername, String rollno, String address, String contact) {
        this.name = name;
        this.fathername = fathername;
        this.rollno = rollno;
        this.address = address;
        this.contact = contact;
    }
    public StudentRecord(String name, String rollno){
        this.name=name;
        this.fathername=rollno;
    }

    public StudentRecord() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void getFathername(String string) {
    }
}
