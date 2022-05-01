package database;

import java.sql.*;

public class selectNorthwind {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root", "");
                Statement stmt = conn.createStatement();
        ){
            String strSelect = "select * from customers";
            System.out.println("The SQL statement is: " + strSelect + "\n");

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");
            int rowCount = 0;
            while (rset.next()) {
                String ContactName = rset.getString("ContactName");
                System.out.println(ContactName);
                ++rowCount;
            }
            System.out.println("Total number of record = " + rowCount);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}