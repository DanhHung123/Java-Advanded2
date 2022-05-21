package Exam_java2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        Tools tool = new Tools(studentList);
        studentList.add(new Student(1,"hoang","hanoi","0987654"));
        studentList.add(new Student(2,"hoang","hanoi","0987654"));
        studentList.add(new Student(3,"hoang","hanoi","0987654"));
        studentList.add(new Student(4,"hoang","hanoi","0987654"));
        studentList.add(new Student(5,"hoang","hanoi","0987654"));
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Student", "root","");
                Statement stmt = conn.createStatement();
                PreparedStatement pstmt = conn.prepareStatement("Insert into Students values (?,?,?,?)");
        ){
            conn.setAutoCommit(false);
            boolean check = true;
            do {
                System.out.println("===== Menu =====");
                System.out.println("1. Add student records");
                System.out.println("2. Display student records");
                System.out.println("3. Save");
                System.out.println("4. Exit");
                System.out.println("5. Display Database"); // Bổ sung thêm
                int select = scan.nextInt();
                scan.nextLine();
                switch (select) {
                    case 1:
                        tool.AddStudent();
                        break;
                    case 2:
                        tool.Display();
                        break;
                    case 3:
                        tool.Save(pstmt);
                        break;
                    case 4:
                        check = false;
                        break;
                    case 5:
                        tool.DisplayDataBase(stmt);
                        break;
                    default:
                        System.out.println("Bad enter the selection !!!");
                        break;
                }
            }while (check);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
