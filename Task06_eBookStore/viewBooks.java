package Task06_eBookStore;

import java.util.Scanner;

public class viewBooks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int chose;
        do{
            System.out.println("1. Xem 10 cuon sach moi nhat");
            System.out.println("2. Xem 100 cuon sach ban chay nhat");
            System.out.println("3. Tim theo the loai");
            System.out.println("4. Tim theo ten tac gia");
            System.out.println("5. Xem chi tiet cuon sach");
            chose = scan.nextInt();
            scan.nextLine();
            switch (chose) {
                case 1 :
                    Print p1 = new Print("select * from Books limit 10");
                    p1.Conec();
                    break;
                case 2 :
                    Print p2 = new Print("select * from Books");
                    p2.Conec();
                    break;
                case 3 :
                    System.out.println("Nhap the loai : ");
                    String select = scan.nextLine();
                    Print p3 = new Print("select * from Books a JOIN categorie b ON a.CateId = b.CateId And b.CateName = '" + select + "'");
                    p3.Conec();
                    break;
                case 4 :
                    System.out.println("Nhap ten tac gia : ");
                    String select4 = scan.nextLine();
                    Print p4 = new Print("select * from Books where Author Like '%" + select4 + "%'");
                    p4.Conec();
                    break;
                case 5 :
                    System.out.println("Nhap id sach :");
                    int slect5 = scan.nextInt();
                    scan.nextLine();
                    Print p5 = new Print("select * from Books where BookId = " + slect5);
                    p5.Conec();
                    break;
            }
        }while (chose<10);
    }
}
