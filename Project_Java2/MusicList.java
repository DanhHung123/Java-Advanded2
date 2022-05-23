package Project_Java2;


import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class MusicList {
    private List<Music> MusicList;
    private Scanner scan = new Scanner(System.in);

    public MusicList(List<Music> MusicList) {
        this.MusicList = MusicList;
    }

    public boolean checkId(int id) {
        boolean check = false;
        for (Music m : MusicList) {
            if (m.getMusicId() == id) {
                check = true;
                break;
            }
        }
        return check;
    }

    public void AddMusic() {
        System.out.println("= Them bai hat =");
        System.out.println("Nhap ID :");
        int id = scan.nextInt();
        scan.nextLine();
        if (checkId(id)) {
            System.out.println("Bai hat da ton tai !!!");
        }else {
            System.out.println("Nhap ten bai hat: ");
            String name = scan.nextLine();
            System.out.println("Nhap ten tac gia: ");
            String author = scan.nextLine();
            System.out.println("Nhap nam phat hanh: ");
            String year = scan.nextLine();
            System.out.println("Nhap the loai: ");
            String type = scan.nextLine();
            MusicList.add(new Music(id,name,author,year,type));
            System.out.println("Them thanh cong !");
        }
    }

    public void UpdateMusic() throws Exception{
        System.out.println("= Chinh sua =");
        System.out.println("Nhap id bai hat can chinh sua :");
        int id = scan.nextInt();
        scan.nextLine();
        if (checkId(id)) {
            try(
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Music", "root","");
                    PreparedStatement psmt = conn.prepareStatement("UPDATE Music set Musicname = ?, Author = ?, years = ?, types = ?");
            ) {

                try {
                    for (Music m : MusicList) {
                        if (m.getMusicId() == id) {
                            System.out.println("Nhap ten bai hat: ");
                            String name = scan.nextLine();
                            m.setMusicName(name);
                            System.out.println("Nhap ten tac gia: ");
                            String author = scan.nextLine();
                            m.setAuthor(author);
                            System.out.println("Nhap nam phat hanh: ");
                            String year = scan.nextLine();
                            m.setYears(year);
                            System.out.println("Nhap the loai: ");
                            String type = scan.nextLine();
                            m.setType(type);
                            System.out.println("Thay doi thanh cong");

                            psmt.setString(1,name);
                            psmt.setString(2,author);
                            psmt.setString(3,year);
                            psmt.setString(4,type);
                            psmt.addBatch();
                            int[] returnRecord = psmt.executeBatch();
                            System.out.println("Return codes are: ");
                            for (int code : returnRecord) System.out.println(code + ", ");
                            System.out.println();
                        }
                    }
                }catch (SQLException ex){
                    ex.printStackTrace();
                    conn.rollback();
                    System.out.println("Sua doi that bai");
                }
            }
        }else {
            System.out.println("Khong tim thay bai hat can chinh sua !!!");
        }

    }

    public void RemoveMusic() throws Exception{
        System.out.println("= Xoa bai hat =");
        System.out.println("Nhap id bai hat can xoa :");
        int id = scan.nextInt();
        scan.nextLine();
        if (checkId(id)) {
            try(
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/Music", "root","");
                    PreparedStatement psmt = conn.prepareStatement("DELETE from Music where id = ?");
            ) {
                try {
                    for (Music m : MusicList) {
                        if (m.getMusicId() == id) {
                            MusicList.remove(m);
                            psmt.setInt(1,id);
                            int count = psmt.executeUpdate();
                            System.out.println(count + "removed");
                            System.out.println("Xoa thanh cong !!!");
                        }
                    }
                }catch (SQLException ex){
                    ex.printStackTrace();
                    conn.rollback();
                    System.out.println("Xoa that bai");
                }
            }
        }else {
            System.out.println("Khong tim thay bai hat can xoa !!!");
        }
    }

    public void SearchMusic() throws Exception{
        System.out.println("= Tim kiem bai hat =");
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Music", "root","");
                PreparedStatement pstm = conn.prepareStatement("Select * from Music where ? Like '%?%'");
        ) {
            try {
                System.out.println("1. Tim theo ten");
                System.out.println("2. Tim theo tac gia");
                System.out.println("3. Tim theo the loai");
                System.out.println("4. Thoat");
                System.out.println("Lua chon :");
                int select = scan.nextInt();
                scan.nextLine();
                boolean check = true;
                do {
                    switch (select) {
                        case 1:
                            System.out.println("Nhap ten bai hat can tim :");
                            String name = scan.nextLine();
                            pstm.setString(1,"MusicName");
                            pstm.setString(2,name);
                            ResultSet rset = pstm.executeQuery();
                            DisplayMeta(rset);
                            break;
                        case 2:
                            System.out.println("Nhap ten tac gia can tim :");
                            String author = scan.nextLine();
                            pstm.setString(1,"Author");
                            pstm.setString(2,author);
                            ResultSet rset2 = pstm.executeQuery();
                            DisplayMeta(rset2);
                            break;
                        case 3:
                            System.out.println("Nhap ten the loai can tim :");
                            String type = scan.nextLine();
                            pstm.setString(1,"Type");
                            pstm.setString(2,type);
                            ResultSet rset3 = pstm.executeQuery();
                            DisplayMeta(rset3);
                            break;
                        case 4:
                            check = false;
                            break;
                        default:
                            System.out.println("Nhap sai lua chon !!!");
                            break;
                    }
                } while (check);
            }catch (SQLException ex){
                ex.printStackTrace();
                conn.rollback();
                System.out.println("Tim kiem that bai !!!");
            }
        }
    }

    public void DisplayArrayList() {
        System.out.println("= Display Arraylist =");
        System.out.printf("%-30s%-30s%-30s%-30s%-30s","MusicId","MusicName","Author","Years","Type");
        System.out.println();
        System.out.println();
        for (Music m : MusicList) {
            m.print();
        }
    }

    public void DisplayMeta(ResultSet rset) throws Exception{
        ResultSetMetaData rmeta = rset.getMetaData();

        int numColumns = rmeta.getColumnCount();
        System.out.println("= Display Database =");
        // Columns name
        for (int i = 1; i <= numColumns; ++i) {
            System.out.printf("%-30s", "(" + rmeta.getColumnName(i) + ")");
        }
        System.out.println();

        while (rset.next()) {
            for (int i = 1; i <= numColumns; ++i) {
                System.out.printf("%-30s", rset.getString(i));
            }
            System.out.println();
        }
    }

    public void DisplayDatabase() throws Exception{
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Music", "root","");
                Statement stmt = conn.createStatement();
        ) {
            try {
                ResultSet rset = stmt.executeQuery("Select * from Music");
                DisplayMeta(rset);
            }catch (SQLException ex){
                ex.printStackTrace();
                conn.rollback();
            }
        }
    }

    public boolean checkIDDatabase(int id) throws Exception{
        boolean check = false;
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Music", "root","");
                Statement stmt = conn.createStatement();
        ) {
            try {
                ResultSet rset = stmt.executeQuery("Select * from Music");
                while (rset.next()) {
                    if (rset.getInt("MusicId") == id) {
                        check = true;
                        break;
                    }
                }
            }catch (SQLException ex){
                ex.printStackTrace();
                conn.rollback();
            }
        }
        return check;
    }
    public void SaveDatabase() throws Exception{
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Music", "root","");
                PreparedStatement pstmt = conn.prepareStatement("Insert into Music values (?,?,?,?,?)")
        ) {
            try {
                int count = 0;
                int fail = 0;
                for (Music m : MusicList) {
                    if (checkIDDatabase(m.getMusicId())){
                        fail++;
                    }else {
                        pstmt.setInt(1, m.getMusicId());
                        pstmt.setString(2, m.getMusicName());
                        pstmt.setString(3, m.getAuthor());
                        pstmt.setString(4, m.getYears());
                        pstmt.setString(5,m.getType());
                        pstmt.addBatch();
                        int[] returnRecord = pstmt.executeBatch();
                        count++;
                    }
                }
                System.out.println( count + " Record inserted");
                System.out.println( fail + " Record insert fail");
            }catch (SQLException ex){
                ex.printStackTrace();
                conn.rollback();
            }
        }
    }
}
