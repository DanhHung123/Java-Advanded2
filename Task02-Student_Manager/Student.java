package Student_Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private int RollNo;
    private String FullName;
    private String DOB;
    private String Address;
    private String Email;
    private int Status;

    public Student(int rollno, String fullname, String DOB, String address, String email, int status) {
        RollNo = rollno;
        FullName = fullname;
        this.DOB = DOB;
        Address = address;
        Email = email;
        Status = status;
    }

    public int getRollNo() {
        return RollNo;
    }

    public void setRollNo(int rollNo) {
        RollNo = rollNo;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
    @Override
    public String toString() {
        return "Student[" +
                "Rollno=" + RollNo +
                ", Fullname='" + FullName + '\'' +
                ", DOB='" + DOB + '\'' +
                ", Address='" + Address + '\'' +
                ", Email='" + Email + '\'' +
                ", Status=" + Status +
                ']';
    }
}
class StudentAraylist {
    public static void main(String[] args) {


        System.out.println("Lua chon cua ban : ");
        Scanner scan = new Scanner(System.in);
        int numberSelect = scan.nextInt();
    }
}
