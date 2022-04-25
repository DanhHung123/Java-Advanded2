package Student_Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private List<Student> students;
    private Scanner scan = new Scanner(System.in);

    public StudentManagement(List<Student> Student) {
        this.students = Student;
    }

    public void printStudent() {
        students.forEach(s -> {
            System.out.println(s.toString());
        });
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean checkRollno(int rollno) {
        boolean check = false;
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getRollNo() == rollno){
                check = true;
            }
        }
        return check;
    }

    public void addStudent() {
        int rollno,status;
        String fullname,dob,address,email;
        System.out.println("Them sinh vien");
        System.out.println("Rollno = ");
        rollno = scan.nextInt();
        if (checkRollno(rollno) == false) {
            System.out.println("Fullname = ");
            fullname = scan.next();
            System.out.println("DOB = ");
            dob = scan.next();
            System.out.println("Address = " );
            address = scan.next();
            System.out.println("Email = ");
            email = scan.next();
            System.out.println("Status = ");
            status = scan.nextInt();
            addStudent(new Student(rollno,fullname,dob,address,email,status));
        }else {
            System.out.println("Sinh vien da ton tai");
        }
    }

    public void setStudents(){
        System.out.println("Nhap rollno sinh vien can sua");
        int rollno = scan.nextInt();
        if (checkRollno(rollno)){
            System.out.println("1. Sua address");
            System.out.println("2. Sua email");
            System.out.println("3. Sua status");
            System.out.println("Lua chon sua :");
            int setNumber = scan.nextInt();
            switch (setNumber) {
                case 1 :
                    System.out.println("Nhap address sua :");
                    String address = scan.next();
                    students.forEach(s -> {
                        if (s.getRollNo() == rollno){
                            s.setAddress(address);
                        }
                    });
                    System.out.println("Sua address thanh cong");
                    break;
                case 2 :
                    System.out.println("Nhap email sua :");
                    String email = scan.next();
                    students.forEach(s -> {
                        if (s.getRollNo() == rollno){
                            s.setEmail(email);
                        }
                    });
                    System.out.println("Sua email thanh cong");
                    break;
                case 3 :
                    System.out.println("Nhap status sua :");
                    int status = scan.nextInt();
                    students.forEach(s -> {
                        if (s.getRollNo() == rollno){
                            s.setStatus(status);
                        }
                    });
                    System.out.println("Sua status thanh cong");
                    break;
                default:
                    System.out.println("Lua chon sai");
                    break;
            }
        }else {
            System.out.println("Sinh vien khong ton tai");
        }
    }

    public void removeStudent() {
        System.out.println("Nhap rollno sinh vien can remove");
        int rollno = scan.nextInt();
        if (checkRollno(rollno)) {
            for (Student s : students) {
                if (s.getRollNo() == rollno){
                    students.remove(s);
                    System.out.println("Remove sinh vien thanh cong");
                    break;
                }
            }
        }else {
            System.out.println("Sinh vien khong ton tai");
        }
    }

    public void sortStudent() {
        students.sort((student1,student2) -> student1.getFullName().compareTo(student2.getFullName()));
        System.out.println("Sap xep thanh cong !!!");
    }

    public void searchStudent() {
        System.out.println("Tim kiem sinh vien :");
        System.out.println("1. Tim theo rollno");
        System.out.println("2. Tim theo ten");
        int numberSelect = scan.nextInt();
        switch (numberSelect) {
            case 1:
                System.out.println("Tim theo rollno(id)");
                System.out.println("Nhap rollno can tim :");
                int rollno = scan.nextInt();
                if (checkRollno(rollno)) {
                    for (Student s : students) {
                        if (s.getRollNo() == rollno){
                            System.out.println("Sinh vien can tim la :");
                            System.out.println(s.toString());
                            break;
                        }
                    }
                }else {
                    System.out.println("Sinh vien can tim khong ton tai");
                }
                break;
            case 2:
                boolean check = true;
                System.out.println("Tim theo ten");
                System.out.println("Nhap ten can tim :");
                String name = scan.next();
                for (Student s : students) {
                    if (s.getFullName().contains(name)){
                        System.out.println("Sinh vien can tim la :");
                        System.out.println(s.toString());
                        check = false;
                        break;
                    }
                }
                if (check == true) {
                    System.out.println("Tim kiem that bai , sinh vien khong ton tai");
                }
                break;
            default:
                System.out.println("Lua chon sai");
                break;
        }
    }
}
