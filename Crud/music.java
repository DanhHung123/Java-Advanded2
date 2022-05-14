package Crud;

import java.sql.*;
import java.util.Scanner;

public class music {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicdata", "root","");
                Statement stmt = conn.createStatement();
        ){
            // Delete
            int countRecord = stmt.executeUpdate("DELETE From music where id = 3");
            System.out.println(countRecord + " records deleted.\n");

            // Insert
            countRecord = stmt.executeUpdate("Insert into music values(11,'Chim sau','MCK',2022),(12,'Thich em hoi nhieu','Wren Evans',2022)");
            System.out.println(countRecord + " records inserted.\n");

            // Update
            countRecord = stmt.executeUpdate("UPDATE music SET `author` = 'Low G' WHERE `music`.`id` = 8;");
            System.out.println(countRecord + " records updated.\n");

            // Search
            Scanner scan = new Scanner(System.in);
            System.out.println("=== Tim kiem ===");
            System.out.println("1. Theo ten");
            System.out.println("2. Theo tac gia");
            int select = scan.nextInt();
            scan.nextLine();
            switch (select) {
                case 1:
                    System.out.println("Nhap ten tim kiem: ");
                    String userSearch = scan.nextLine();
                    ResultSet rset = stmt.executeQuery("SELECT * from music where name LIKE '%" + userSearch + "%'");
                    while (rset.next()) {
                        System.out.println(rset.getInt("id") + ","
                                + rset.getString("name") + ","
                                + rset.getString("author") + ","
                                + rset.getInt("years"));
                    }
                    break;
                case 2:
                    System.out.println("Nhap ten tac gia tim kiem: ");
                    String search = scan.nextLine();
                    ResultSet rset2 = stmt.executeQuery("SELECT * from music where author LIKE '%" + search + "%'");
                    while (rset2.next()) {
                        System.out.println(rset2.getInt("id") + ","
                                + rset2.getString("name") + ","
                                + rset2.getString("author") + ","
                                + rset2.getInt("years"));
                    }
                    break;
            }



//            rset = stmt.executeQuery("SELECT * from music");
//            while (rset.next()) {
//                System.out.println(rset.getInt("id") + ","
//                        + rset.getString("name") + ","
//                        + rset.getString("author") + ","
//                        + rset.getInt("years"));
//            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
