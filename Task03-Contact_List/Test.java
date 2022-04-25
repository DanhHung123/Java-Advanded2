package Contact_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Nguyen Dinh Nhien" , "034588558"));
        contacts.add(new Contact("Vuong Van Quyen" , "05769812658"));
        contacts.add(new Contact("Dinh Thi Ngoc" , "098765154545"));
        contacts.add(new Contact("Tran Thi Hai" , "07736885812"));
        contacts.add(new Contact("Nguyen Tien Dat" , "0657915558545"));
        ContactList contactList = new ContactList(contacts);

        Scanner scan = new Scanner(System.in);
        int select;
        do {
            System.out.println("======List======");
            System.out.println("1. In danh ba");
            System.out.println("2. Them nguoi moi vao danh ba");
            System.out.println("3. Sua danh ba");
            System.out.println("4. Xoa nguoi khoi danh ba");
            System.out.println("5. Tim kiem trong danh ba");
            select = scan.nextInt();
            switch (select){
                case 1:
                    System.out.println("List danh ba cua ban : ");
                    contactList.printList();
                    break;
                case 2:
                    System.out.println("Them doi tuong moi");
                    System.out.println("Nhap ten nguoi lien he:");
                    String name = scan.next();
                    System.out.println("Nhap SDT lien he :");
                    String phone = scan.next();
                    contactList.addContact(new Contact(name,phone));
                    System.out.println("Them thanh cong lien he : Name = " + name + ",Phone=" + phone);
                    break;
                case 3:
                    System.out.println("Sua doi tuong trong danh ba ");
                    System.out.println("Nhap ten doi tuong can sua:");
                    String nameChange = scan.next();
                    if (contactList.checkName(nameChange)) {
                        for (Contact c : contacts) {
                            if (c.getName().contains(nameChange)){
                                System.out.println("Doi tuong ban muon thay doi la :" + c.toString());
                                System.out.println("Ten thay doi : ");
                                String nameUpdate = scan.next();
                                c.setName(nameUpdate);
                                System.out.println("SDT thay doi :");
                                String phoneUpdate = scan.next();
                                c.setPhone(phoneUpdate);
                                System.out.println("Doi tuong sau khi thay doi :");
                                System.out.println(c.toString());
                                break;
                            }
                        }
                    }else {
                        System.out.println("Doi tuong can thay doi khong ton tai");
                    }
                    break;
                case 4:
                    System.out.println("Nhap ten doi tuong can remove :");
                    String nameRemove = scan.next();
                    contactList.removeContact(nameRemove);
                    break;
                case 5:
                    System.out.println("Nhap ten doi tuong can tim kiem :");
                    String nameSearch = scan.next();
                    contactList.searchContact(nameSearch);
                    break;
                default:
                    System.out.println("Chon sai");
                    break;
            }
        }while (select < 6);
    }
}
