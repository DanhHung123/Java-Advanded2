package Task06_eBookStore;

import java.sql.*;

public class test {
    public static void main(String[] args) {
        try (Connection conect = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root",
                "");
             Statement stt = conect.createStatement();
        ){
            String select2 = "select * from Oders a join OderDetail b ON a.OderId = b.OderId And a.OderId = 5";
            ResultSet tset = stt.executeQuery(select2);
            int record = 0;
            while (tset.next()){
                int id = tset.getInt("OderId");
                String date =  tset.getString("DateOder");
                int cusId = tset.getInt("CusId");
                int bookId = tset.getInt("BookId");
                System.out.println(id + "," + date + "," + cusId + "," + bookId);
                ++record;
            }
            System.out.println("Record=" + record);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
