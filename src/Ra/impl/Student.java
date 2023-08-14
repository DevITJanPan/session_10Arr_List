package Ra.impl;

import Ra.IStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student implements IStudent {
    private String studentId;
    private String studentName;
    private int age;
    private float html;
    private float css;
    private float javascript;
    private float avgMark;
    private boolean sex;
    private String rank;
    private String studentStatus;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, float html, float css, float javascript, float avgMark, boolean sex, String rank, String studentStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.html = html;
        this.css = css;
        this.javascript = javascript;
        this.avgMark = avgMark;
        this.sex = sex;
        this.rank = rank;
        this.studentStatus = studentStatus;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHtml() {
        return html;
    }

    public void setHtml(float html) {
        this.html = html;
    }

    public float getCss() {
        return css;
    }

    public void setCss(float css) {
        this.css = css;
    }

    public float getJavascript() {
        return javascript;
    }

    public void setJavascript(float javascript) {
        this.javascript = javascript;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }
    public void inputData(List<Student> studentList) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Nhập mã sinh viên: ");
        studentId = scanner.nextLine();
        while (isExistIdStudent(studentId) && !studentId.startsWith("SV") && studentId.length() != 4) {
            System.out.println("Mã sinh viên phải gồm 4 ký tự và bắt đầu bằng SV hoặc mã sinh viên đã tồn tại. Vui lòng nhập lại.");
            System.out.print("Nhập mã sinh viên: ");
            studentId = scanner.nextLine();
        }
        System.out.print("Nhập tên sinh viên: ");
        studentName = scanner.nextLine();

        while (!checkLength(studentName)) {
            System.out.println("Tên sinh viên phải từ 6-50 ký tự");
            System.out.print("Nhập tên sinh viên: ");
            studentName = scanner.nextLine();
        }
        System.out.print("Nhập tuổi: ");
        age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập điểm HTML: ");
        html = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Nhập điểm CSS: ");
        css = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Nhập điểm JavaScript: ");
        javascript = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Sinh viên là nam? (true/false): ");
        sex = scanner.nextBoolean();
        scanner.nextLine();
    }

    @Override
    public void inputData() {

    }

    @Override
    public void displayData() {
        System.out.printf("Mã SV: %s - Tên SV: %s - Tuổi: %d\n", this.studentId, this.studentName, this.age);
        System.out.printf("HTML: %.1f - CSS: %.1f - Javascript: %.1f - AvgMark: %.1f\n", this.html, this.css, this.javascript, this.avgMark);
        String studentSex = (this.sex) ? "Nam" : "Nữ";
        System.out.printf("Giới tính: %s - Xếp loại: %s - Trạng thái: %s\n", studentSex, this.rank, this.studentStatus);
    }
    @Override
    public float calAvgMark() {
        this.avgMark=(this.html+this.css+this.javascript)/3;
        return 0;
    }
    public void calRank(){
        if(this.avgMark<5){
            this.rank="Yếu";
        }else if(this.avgMark<7){
            this.rank="Trung bình";
        } else if(this.avgMark<8){
            this.rank="Khá";
        } else if(this.avgMark<9){
            this.rank="Giỏi";
        }else{
            this.rank="Xuất sắc";
        }
    }
    public void calStudentStatus(){
        if(this.avgMark<MARK_PASS){
            this.studentStatus="FAIL";
        }else{
            this.studentStatus="PASS";
        }
    }
    boolean isExistIdStudent(String studentId) {
        List<Student> studentList=new ArrayList<>();
        for (Student studentLists : studentList) {
            if (studentLists.studentId.equals(studentId)) {
                return true;
            }
        }
        return false;
    }

    boolean checkLength(String studentName) {
        return studentName.length() >= 6 && studentName.length() <= 50;
    }
}
