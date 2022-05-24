package Project_Java2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicList {
    private List<Music> MusicList;
    private Scanner scan = new Scanner(System.in);
    private List<Music> MusicList2 = new ArrayList<>();

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
    public boolean checkId2(int id) {
        boolean check = false;
        for (Music m : MusicList2) {
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
        if (checkId(id) && checkId2(id)) {
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
            MusicList2.add(new Music(id,name,author,year,type));
            System.out.println("Them thanh cong !");
        }
    }

    public void Synchronized(Statement stmt) throws Exception{
        ResultSet rset = stmt.executeQuery("Select * From Music");
        int count = 0;
        int id;
        String name, author, year, type;
        MusicList.clear();
        MusicList2.clear();
        while (rset.next()){
            id = rset.getInt("MusicId");
            name = rset.getString("MusicName");
            author = rset.getString("Author");
            year = rset.getString("Years");
            type = rset.getString("Types");
            MusicList.add(new Music(id,name,author,year,type));
            count++;
        }
        System.out.println(count + " ban ghi dong bo thanh cong");
    }
    public void UpdateMusic(PreparedStatement psmt) throws Exception{
        System.out.println("= Chinh sua =");
        System.out.println("Nhap id bai hat can chinh sua :");
        int id = scan.nextInt();
        scan.nextLine();
        if (checkId(id)) {
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
                    psmt.setInt(5,id);
                    psmt.addBatch();
                    int[] returnRecord = psmt.executeBatch();
                    System.out.println("Return codes are: ");
                    for (int code : returnRecord) System.out.println(code + ", ");
                    System.out.println();
                }
            }
        }else {
            System.out.println("Khong tim thay bai hat can chinh sua !!!");
        }

    }

    public void RemoveMusic(Statement psmt) throws Exception{
        System.out.println("= Xoa bai hat =");
        System.out.println("Nhap id bai hat can xoa :");
        int id = scan.nextInt();
        scan.nextLine();
        if (checkId(id)) {
            for (Music m : MusicList) {
                if (m.getMusicId() == id) {
                    MusicList.remove(m);
                    int count = psmt.executeUpdate("DELETE FROM Music WHERE MusicId = " + id);
                    System.out.println(count + "removed");
                    System.out.println("Xoa thanh cong !!!");
                    break;
                }
            }
        }else {
            System.out.println("Khong tim thay bai hat can xoa !!!");
        }
    }

    public void SearchMusic(Statement stmt) throws Exception{
        boolean check = true;
        do {
            System.out.println("= Tim kiem bai hat =");
            System.out.println("1. Tim theo ten");
            System.out.println("2. Tim theo tac gia");
            System.out.println("3. Tim theo the loai");
            System.out.println("4. Thoat");
            System.out.println("Lua chon :");
            int select = scan.nextInt();
            scan.nextLine();
            switch (select) {
                case 1:
                    System.out.println("Nhap ten bai hat can tim :");
                    String name = scan.nextLine();
                    ResultSet rset = stmt.executeQuery("Select * from Music WHERE MusicName Like '%" + name + "%'");
                    DisplayMeta(rset);
                    break;
                case 2:
                    System.out.println("Nhap ten tac gia can tim :");
                    String author = scan.nextLine();
                    ResultSet rset2 = stmt.executeQuery("Select * from Music WHERE Author Like '%" + author + "%'");
                    DisplayMeta(rset2);
                    break;
                case 3:
                    System.out.println("Nhap ten the loai can tim :");
                    String type = scan.nextLine();
                    ResultSet rset3 = stmt.executeQuery("Select * from Music WHERE Types Like '%" + type + "%'");
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

    public void DisplayDatabase(Statement stmt) throws Exception{
        ResultSet rset = stmt.executeQuery("Select * from Music");
        DisplayMeta(rset);
    }

    public void SaveDatabase(PreparedStatement pstmt, Statement stmt) throws Exception{
        int count = 0;
        for (Music m : MusicList2) {
            pstmt.setInt(1, m.getMusicId());
            pstmt.setString(2, m.getMusicName());
            pstmt.setString(3, m.getAuthor());
            pstmt.setString(4, m.getYears());
            pstmt.setString(5,m.getType());
            pstmt.addBatch();
            int[] returnRecord = pstmt.executeBatch();
            count++;
        }
        System.out.println( count + " Record inserted");
        Synchronized(stmt);
    }
}
