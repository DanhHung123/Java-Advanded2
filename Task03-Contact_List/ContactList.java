package Contact_List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactList {
    private List<Contact> contactList;
    private Scanner scan = new Scanner(System.in);

    public boolean checkName(String name) {
        boolean check = false;
        for (Contact c : contactList) {
            if (c.getName().contains(name)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public ContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public void printList() {
        for (Contact c : contactList) {
            System.out.println(c.toString());
        }
    }

        public void addContact(Contact contact) {
        contactList.add(contact);
    }

    public void updateContact(Contact oldContact, Contact newContact) {
        for (Contact c : contactList) {
            if (c.getName().contains(oldContact.getName())) {
                c.setName(newContact.getName());
                c.setPhone(newContact.getPhone());
                System.out.println("Doi tuong sau khi thay doi:");
                System.out.println(c.toString());
                break;
            }
        }
    }

    public void removeContact(String name) {
        if (checkName(name)) {
            for (Contact c : contactList) {
                if (c.getName().contains(name)) {
                    contactList.remove(c);
                    System.out.println("Xoa doi tuong thanh cong");
                    break;
                }
            }
        }else {
            System.out.println("Doi tuong khong ton tai");
        }
    }

    public void searchContact(String name) {
        if (checkName(name)) {
            for (Contact c : contactList) {
                if (c.getName().contains(name)){
                    System.out.println("Doi tuong ban tim kiem la:");
                    System.out.println(c.toString());
                    break;
                }
            }
        }else {
            System.out.println("Khong tim thay doi tuong");
        }
    }

}
