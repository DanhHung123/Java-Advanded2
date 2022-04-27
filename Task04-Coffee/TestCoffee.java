package Coffee;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCoffee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu(1,"coffee",200,null));
        menuList.add(new Menu(2,"sinh to",180,null));
        menuList.add(new Menu(3,"nuoc ep",300,null));
        menuList.add(new Menu(4,"coca cola",150,null));
        menuList.add(new Menu(5,"tra chanh",100,null));

        MenuList menuListAdd = new MenuList(menuList);
        int numberSelect;
        do {
            System.out.println("===Admin===");
            System.out.println("1. Them mon moi");
            System.out.println("2. Sua mon");
            System.out.println("3. Xoa mon");
            System.out.println("===User===");
            System.out.println("4. Tim kiem mon");
            System.out.println("5. Hien thi menu");
            System.out.println("6. Goi mon");
            System.out.println("======");
            numberSelect = scan.nextInt();
            scan.nextLine();
            List<Menu> buyCoffee = new ArrayList<>();
            double total = 0;
            switch (numberSelect) {
                case 1:
                    menuListAdd.addMenu();
                    break;
                case 2:
                    menuListAdd.updateMenu();
                    break;
                case 3:
                    menuListAdd.removeMenu();
                    break;
                case 4:
                    menuListAdd.searchMenu();
                    break;
                case 5:
                    menuListAdd.printMenu();
                    break;
                case 6:
                    menuListAdd.printMenu();
                    String call;
                    boolean check = true;
                    do {
                        System.out.println("Nhap id mon ban muon:");
                        int idBuy = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Size mon :");
                        String size = scan.nextLine();

                        for (Menu c : menuList) {
                            if (c.getId() == idBuy){
                                c.setSize(size);
                                buyCoffee.add(c);
                            }
                        }
                        total += menuListAdd.buyCoffee(buyCoffee);
                        System.out.println("Ban muon chon tiep khong");
                        call = scan.nextLine();
                        if (call.equals("No")){
                            check = false;
                        }
                    }while (check);
                    menuListAdd.printBill(buyCoffee);
                    System.out.println("Tong tien san pham: " + total);
                    System.out.println("Thue VAT: " + total * 0.1);
                    System.out.println("Tong tien phai tra: " + (total + (total * 0.1)));
                    break;
                default:
                    System.out.println("Chon sai");
                    break;
            }
        }while (numberSelect < 7);
    }
}
