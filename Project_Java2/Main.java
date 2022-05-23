package Project_Java2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        List<Music> musicList = new ArrayList<>();
        MusicList menu = new MusicList(musicList);
        boolean check = true;
        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Them bai hat moi vao list");
            System.out.println("2. Luu vào Database");
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
                    menu.SaveDatabase();
                    break;
                case 3:
                    menu.UpdateMusic();
                    break;
                case 4:
                    menu.RemoveMusic();
                    break;
                case 5:
                    menu.SearchMusic();
                    break;
                case 6:
                    menu.DisplayArrayList();
                    break;
                case 7:
                    menu.DisplayDatabase();
                    break;
                case 8:
                    check = false;
                    break;
                default:
                    System.out.println("Lua chon sai !!!");
                    break;
            }
        }while (check);
    }
}
