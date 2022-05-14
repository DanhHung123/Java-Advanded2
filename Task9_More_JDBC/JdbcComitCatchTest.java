package More_JDBC;

import java.sql.*;

public class JdbcComitCatchTest {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop", "root","");
                Statement stmt = conn.createStatement();
        ){
            try {
                conn.setAutoCommit(false);

                stmt.executeUpdate("insert into books values (4001,'Paul Chan', 'Mahjong 101',4.4,4)");

                stmt.executeUpdate("insert into books values (4001,'Paul Chan', 'Mahjong 102',4.4,4)");
                conn.commit();   // Commit changes only if all statements succeed.
            }catch (SQLException ex){
                System.out.println("-- Rolling back changes --");
                conn.rollback();  // Rollback to the last commit.
                ex.printStackTrace();
            }

        }
    }
}
