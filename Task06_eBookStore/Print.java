package Task06_eBookStore;

import java.sql.*;

public class Print {
    private String slect;
    public Print(String slect) {
        this.slect = slect;
    }
    public void Conec() {
        try (Connection conect = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root",
                "");
             Statement stm = conect.createStatement();
        ){
            String select = slect;
            ResultSet rset = stm.executeQuery(select);
            int record = 0;
            while (rset.next()){
                int Id = rset.getInt("BookId");
                String name = rset.getString("Name");
                double Price = rset.getDouble("Price");
                int qty = rset.getInt("Qty");
                String Author = rset.getString("Author");
                System.out.println(Id + "," + name + "," + Price + "," + qty + "," + Author);
                ++record;
            }
            System.out.println("Record=" + record);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void conec2() {
        try(Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root",
                "");
            Statement stmm = conn.createStatement();
        ){
            String chose = slect;
            ResultSet rseto = stmm.executeQuery(chose);
            int recod = 0;
            while(rseto.next()){
                int id = rseto.getInt("OderId");
                String date =  rseto.getString("DateOder");
                int cusId = rseto.getInt("CusId");
                int bookId = rseto.getInt("BookId");
                System.out.println(id + "," + date + "," + cusId + "," + bookId);
                ++recod;
            }
            System.out.println("Record=" + recod);
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
