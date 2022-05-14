package More_JDBC;

import java.sql.*;

public class AtomicTransaction {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url,user,password);
            Statement stmt = conn.createStatement();

            conn.setAutoCommit(false);

            // Before Changes
            ResultSet rset = stmt.executeQuery("Select id, qty from books where id in(1001,1002)");
            System.out.println("-- Before UPDATE --");
            while(rset.next()) {
                System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
            }
            conn.commit();  // Commit Select

            // Issue two UPDATE statements thru executeUpdate()
            stmt.executeUpdate("update books set qty = qty + 1 where id = 1001");
            stmt.executeUpdate("update books set qty = qty + 1 where id = 1002");
            conn.commit();  // Commit update

            rset = stmt.executeQuery("select id, qty from books where id in (1001,1002)");
            while (rset.next()) {
                System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
            }
            conn.commit();  // Commit Select

            //  Issue two UPDATE statements thru executeUpdate()
            stmt.executeUpdate("update books set qty = qty -99 where id = 1001");
            stmt.executeUpdate("update books set qty = qty -99 where id = 1002");
            conn.rollback();  // Discard all changes since the last commit

            rset = stmt.executeQuery("SELECT id, qty from books where id in (1001, 1002)");
            System.out.println("-- After UPDATE and Rollback --");
            while (rset.next()) {
                System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
            }
            conn.commit();  // Commit Select
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
