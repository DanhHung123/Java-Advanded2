package Student_Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"Anh","22/10/1998","Ha Noi","anh@eamail.com",1));
        studentList.add(new Student(2,"Hoang","13/02/1999","Bac Ninh","hoang@eamail.com",1));
        studentList.add(new Student(3,"Minh","23/07/1995","Nam Dinh","minh@eamail.com",0));
        studentList.add(new Student(4,"Nguyen Van Huy","18/09/1994","Ha Noi","huy@eamail.com",1));
        studentList.add(new Student(5,"Vinh","27/10/1992","Thanh Hoa","vinh@eamail.com",0));

        StudentManagement stuMana = new StudentManagement(studentList);
        int numberSelect;
        do {
            System.out.println("======Menu======");
            System.out.println("Lua chon cua ban la :");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Sua thong tin sinh vien");
            System.out.println("3. Xoa sinh vien");
            System.out.println("4. Sap xep sinh vien");
            System.out.println("5. Tim kiem sinh vien");
            System.out.println("6. In danh sach sinh vien");
            System.out.println();
            numberSelect = scan.nextInt();
            switch (numberSelect){
                case 1:
                    stuMana.addStudent();
                    break;
                case 2:
                    stuMana.setStudents();
                    break;
                case 3:
                    stuMana.removeStudent();
                    break;
                case 4:
                    stuMana.sortStudent();
                    break;
                case 5:
                    stuMana.searchStudent();
                    break;
                case 6:
                    stuMana.printStudent();
                    break;
                default:
                    System.out.println("Chon sai");
                    break;
            }
        }while (numberSelect < 7);
    }
}
