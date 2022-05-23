package Exam_java2;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Tools {
    private List<Student> StudentList;
    private Scanner scan = new Scanner(System.in);

    public Tools(List<Student> stulist) {
        this.StudentList = stulist;
    }
    public boolean checkID(int id) {
        boolean check = false;
        for (Student s : StudentList) {
            if (s.getStudentId() == id){
                check = true;
                break;
            }
        }
        return check;
    }

    public void AddStudent() {
        System.out.println("= Add Student =");
        System.out.println("Enter StudentID : ");
        int id = scan.nextInt();
        scan.nextLine();
        if (checkID(id)) {
            System.out.println("Students already exist !");
        }else {
            System.out.println("Enter StudentName :");
            String name = scan.nextLine();
            System.out.println("Enter Address :");
            String address = scan.nextLine();
            System.out.println("Enter Phone :");
            String phone = scan.nextLine();
            StudentList.add(new Student(id,name,address,phone));
            System.out.println("Success !!!");
        }

    }

    public void DisplayDataBase(Statement stmt) throws Exception {
        ResultSet rset = stmt.executeQuery("SELECT * FROM Students ");
        ResultSetMetaData rsetMD = rset.getMetaData();

        int numColumns = rsetMD.getColumnCount();
        System.out.println("= Display Database =");
        // Columns name
        for (int i = 1; i <= numColumns; ++i) {
            System.out.printf("%-30s", "(" + rsetMD.getColumnName(i) + ")");
        }
        System.out.println();

        while (rset.next()) {
            for (int i = 1; i <= numColumns; ++i) {
                System.out.printf("%-30s", rset.getString(i));
            }
            System.out.println();
        }
    }

    public void Display() {
        System.out.println("= Display Arraylist =");
        System.out.printf("%-30s%-30s%-30s%-30s","StudentId","StudentName","Address","Phone");
        System.out.println();
        System.out.println();
        for (Student s : StudentList) {
            s.print();
        }
    }
    public void Save(PreparedStatement pstmt) throws Exception{
        int count = 0;
        for (Student s : StudentList) {
            pstmt.setInt(1, s.getStudentId());
            pstmt.setString(2, s.getStudentName());
            pstmt.setString(3, s.getAddress());
            pstmt.setString(4, s.getPhone());
            pstmt.executeUpdate();
            count++;
        }
        System.out.println( count + " Record inserted");
    }
}
