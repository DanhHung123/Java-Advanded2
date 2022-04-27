package Coffee;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuList {
    private List<Menu> menuList;
    private Scanner scan = new Scanner(System.in);

    public MenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public boolean checkId(int id){
        boolean check = false;
        for (Menu m : menuList) {
            if (m.getId() == id){
                check = true;
                break;
            }
        }
        return check;
    }

    public void addMenu() {
        System.out.println("Them mon moi");
        System.out.println("Nhap id mon moi:");
        int id = scan.nextInt();
        scan.nextLine();
        if (checkId(id)){
            System.out.println("Mon da ton tai");
        }else {
            System.out.println("Nhap ten mon moi:");
            String name = scan.nextLine();
            System.out.println("Nhap gia ban:");
            int price = scan.nextInt();
            scan.nextLine();
            menuList.add(new Menu(id,name,price,null));
            System.out.println("Them mon moi thanh cong !!!");
        }
    }

    public void updateMenu() {
        System.out.println("Chinh sua mon");
        System.out.println("Nhap id mon can sua:");
        int id = scan.nextInt();
        scan.nextLine();
        if (checkId(id)) {
            for (Menu m : menuList) {
                if (m.getId() == id){
                    System.out.println("Nhap ten thay doi:");
                    String name = scan.nextLine();
                    System.out.println("Nhap gia thay doi:");
                    int price = scan.nextInt();
                    scan.nextLine();
                    m.setName(name);
                    m.setPrice(price);
                    System.out.println("Sua thanh cong!!!");
                    break;
                }
            }
        }else {
            System.out.println("Mon khong ton tai");
        }
    }

    public void removeMenu() {
        System.out.println("Xoa mon");
        System.out.println("Nhap id mon can xoa:");
        int id = scan.nextInt();
        scan.nextLine();
        if (checkId(id)) {
            for (Menu m : menuList) {
                if (m.getId() == id){
                    menuList.remove(m);
                    System.out.println("Xoa mon thanh cong!!!");
                    break;
                }
            }
        }else {
            System.out.println("Mon khong ton tai");
        }
    }

    public void searchMenu() {
        System.out.println("Tim kiem mon");
        System.out.println("Nhap id mon tim kiem:");
        int id = scan.nextInt();
        scan.nextLine();
        if (checkId(id)) {
            for (Menu m : menuList) {
                if (m.getId() == id){
                    System.out.println("Mon tim kiem la: " + m.toString());
                    break;
                }
            }
        }else {
            System.out.println("Mon khong ton tai");
        }
    }

    public void printMenu(){
        for (Menu m : menuList) {
            System.out.println(m.toString());
        }
        System.out.println("Phi them cho size:");
        System.out.println("Size + 0");
        System.out.println("Size + 100");
        System.out.println("Size + 200");
    }

    public double buyCoffee(List<Menu> buyCoffee) {
        double total = 0;
        for (Menu m : buyCoffee) {
            if (m.getSize().equals("S")) {
                total = m.getPrice();
            }
            else if (m.getSize().equals("M")){
                total = m.getPrice() + 100;
            }
            else if (m.getSize().equals("L")) {
                total = m.getPrice() + 200;
            }
        }
        return total;
    }

    public void printBill(List<Menu> listBill) {
        System.out.println("=====Bill=====");
        for (int i = 0; i<listBill.size();i++) {
            System.out.println((i+1) + ". " + listBill.get(i).getName() + "-----" + listBill.get(i).getPrice());
        }
    }
}
