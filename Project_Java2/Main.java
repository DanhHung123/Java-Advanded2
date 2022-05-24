package Project_Java2;

import Coffee.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/MusicData", "root","");
                Statement stmt = conn.createStatement();
                PreparedStatement psmt = conn.prepareStatement("UPDATE Music set MusicName = ?, Author = ?, Years = ?, Types = ? where MusicId = ?");
                PreparedStatement pstmt = conn.prepareStatement("Insert into Music values (?,?,?,?,?)")
        ) {
            try {
                conn.setAutoCommit(false);
                Scanner scan = new Scanner(System.in);
                List<Music> musicList = new ArrayList<>();
                MusicList menu = new MusicList(musicList);
                menu.Synchronized(stmt);
                boolean check = true;
                do {
                    System.out.println("===== MENU =====");
                    System.out.println("1. Them bai hat moi vao list");
                    System.out.println("2. Luu vao Database");
                    System.out.println("3. Chinh sua bai hat");
                    System.out.println("4. Xoa bai hat");
                    System.out.println("5. Tim kiem bai hat");
                    System.out.println("6. Hien thi list");
                    System.out.println("7. Hien thi Database");
                    System.out.println("8. Thoat");
                    int select = scan.nextInt();
                    switch (select) {
                        case 1:
                            menu.AddMusic();
                            break;
                        case 2:
                            menu.SaveDatabase(pstmt,stmt);
                            break;
                        case 3:
                            menu.UpdateMusic(psmt);
                            break;
                        case 4:
                            menu.RemoveMusic(stmt);
                            break;
                        case 5:
                            menu.SearchMusic(stmt);
                            break;
                        case 6:
                            menu.DisplayArrayList();
                            break;
                        case 7:
                            menu.DisplayDatabase(stmt);
                            break;
                        case 8:
                            check = false;
                            break;
                        default:
                            System.out.println("Lua chon sai !!!");
                            break;
                    }
                }while (check);
            }catch (SQLException ex){
                ex.printStackTrace();
                conn.rollback();
            }
        }
    }
}
