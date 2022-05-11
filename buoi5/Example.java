package buoi5;

import java.sql.*;

public class Example {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root",
                        "");
                Statement stm = conn.createStatement();
                )
        {
            // Update
            String sqlUpdate = "Uppdate books Set qty = 15 where books.id = 1001";
            int countRecord = stm.executeUpdate(sqlUpdate);
            System.out.println("Record = " + countRecord);

            // Delete
            String sqlDelete = "delete from books where id > 3000";
            countRecord = stm.executeUpdate(sqlDelete);
            System.out.println("Record = " + countRecord);

            // Insert
            String sqlInsert = "Insert into books values (5888, 'SQL Database', 'group2', 23.44, 30)";
            countRecord = stm.executeUpdate(sqlInsert);
            System.out.println("Record = " + countRecord);

            // Search
            String sqlSeach = "Select * from books where title LIKE '%Java%' ";
            countRecord = stm.executeUpdate(sqlSeach);
            System.out.println("Record = " + countRecord);

            // Print
            String strSelect = "select * from books";
            ResultSet rset = stm.executeQuery(strSelect);
            while (rset.next()) {
                System.out.println(rset.getInt("id") + ","
                        + rset.getString("author") + ","
                        + rset.getString("title") + ","
                        + rset.getDouble("price") + ","
                        + rset.getInt("qty"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
