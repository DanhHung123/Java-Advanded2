package Task07_Insert_and_Delete;

import java.sql.*;
import java.util.Scanner;

public class BaiTap1 {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        "root",
                        "" );
                Statement stmt = conn.createStatement();
        ){
            // Xóa tất cả sách có ID > 8000
            String deleteBook = "delete from books where id > 8000";
            System.out.println("The SQL statement is: " + deleteBook + "\n");
            int countBooks = stmt.executeUpdate(deleteBook);
            System.out.println(countBooks + " records deleted.\n");
            System.out.println("=======");

            // Thêm cùng lúc2bản ghi (8001, 'Java Core', 'Dang Kim Thi', 15.55, 55) và (8002, 'Java Advanced', 'Jame Gosling', 25.55, 55);
            String insertBooks = "Insert into books values (8001, 'Java Core', 'Dang Kim Thi', 15.55, 55),"
                               + "(8002, 'Java Advanced', 'Jame Gosling', 25.55, 55)";
            System.out.println("The SQL statement is: " + insertBooks + "\n");
            countBooks = stmt.executeUpdate(insertBooks);
            System.out.println(countBooks + " records inserted.\n");
            System.out.println("=======");

            // Thêm 1 cuốn sách có thông tin là (2001, 'Java JDBC MYSQL', 'ThiDK');
            String insertBook2 = "insert into books (id, title, author) values (2001, 'Java JDBC MYSQL', 'ThiDK')";
            System.out.println("The SQL statement is: " + insertBook2 + "\n");
            countBooks = stmt.executeUpdate(insertBook2);
            System.out.println(countBooks + " records inserted.\n");
            System.out.println("=======");

            // Xoá một cuối sách có id là do người dùng nhập vào, ví dụ id=2001
            Scanner scan = new Scanner(System.in);
            System.out.println("Nhap id sach muon xoa: ");
            int selectId = scan.nextInt();
            scan.nextLine();
            String detleteBookUser = "delete from books where id = " + selectId;
            countBooks = stmt.executeUpdate(detleteBookUser);
            System.out.println(countBooks + " records deleted.\n");
            System.out.println("=======");

            // Thêm mới một cuốn sách có đầy đủ thông tin do người dùng nhập vào từ bàn phím
            System.out.println("Them sach moi");
            System.out.println("Nhap id: ");
            int idUser = scan.nextInt();
            scan.nextLine();
            System.out.println("Nhap Name: ");
            String nameUser = scan.nextLine();
            System.out.println("Nhap Author: ");
            String authorUser = scan.nextLine();
            System.out.println("Nhap Price: ");
            int priceUser = scan.nextInt();
            scan.nextLine();
            System.out.println("Nhap Qty: ");
            int qtyUser = scan.nextInt();
            String insertBook3 = "insert into books values ("+ idUser + "," + "'" + nameUser + "'" + "," + "'" + authorUser + "'" + "," + priceUser + "," + qtyUser +")";
            System.out.println("The SQL statement is: " + insertBook3 + "\n");
            countBooks = stmt.executeUpdate(insertBook3);
            System.out.println(countBooks + " records inserted.\n");

            String selectAll = "select * from books";
            System.out.println("The SQL statement is: " + selectAll + "\n");
            ResultSet rset2 = stmt.executeQuery(selectAll);
            while (rset2.next()) {
                System.out.println(rset2.getInt("id") + ","
                        + rset2.getString("author") + ","
                        + rset2.getString("title") + ","
                        + rset2.getDouble("price") + ","
                        + rset2.getInt("qty"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
