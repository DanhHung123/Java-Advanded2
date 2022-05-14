package More_JDBC;

import java.sql.*;

public class ResultSetMetaDataExample {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stmt = conn.createStatement();

            ResultSet rset = stmt.executeQuery("Select * from books");

            ResultSetMetaData rsetMD = rset.getMetaData();

            int numColumns = rsetMD.getColumnCount();

            // Columns name
            for (int i = 1; i <= numColumns; ++i) {
                System.out.printf("%-30s", "(" + rsetMD.getColumnName(i) + ")");
            }
            System.out.println();

            // Class columns name
            for (int i = 1; i <= numColumns; ++i) {
                System.out.printf("%-30s", "(" + rsetMD.getColumnClassName(i) + ")");
            }
            System.out.println();

            while (rset.next()) {
                for (int i = 1; i <= numColumns; ++i) {
                    System.out.printf("%-30s", rset.getString(i));
                }
                System.out.println();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
