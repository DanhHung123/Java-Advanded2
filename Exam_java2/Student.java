package Exam_java2;

public class Student {
    int StudentId;
    String StudentName;
    String Address;
    String Phone;

    public Student(int studentId, String studentName, String address, String phone) {
        StudentId = studentId;
        StudentName = studentName;
        Address = address;
        Phone = phone;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentId=" + StudentId +
                ", StudentName='" + StudentName + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }

    public void print() {
        System.out.printf("%-30s%-30s%-30s%-30s",StudentId , StudentName , Address , Phone);
        System.out.println();
    }
}
