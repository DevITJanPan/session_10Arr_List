package Ra.run;
import Ra.impl.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    public static final List<Student> studentList=new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            System.out.println("******************MENU*****************");
            System.out.println("1. Nhập thông tin các sinh viên");
            System.out.println("2. Tính điểm trung bình các sinh viên");
            System.out.println("3. Đánh giá xếp loại sinh viên");
            System.out.println("4. Tính trạng thái sinh viên");
            System.out.println("5. In thông tin các sinh viên");
            System.out.println("6. Sắp xếp sinh viên tăng dần theo điểm trung bình");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê sinh viên theo xếp loại");
            System.out.println("9. Thống kê sinh viên theo trạng thái");
            System.out.println("10. Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.inputListStudent();
                    break;
                case 2:
                    StudentManagement.calAvgMark();
                    break;
                case 3:
                    StudentManagement.calRank();
                    break;
                case 4:
                    StudentManagement.calStudentStatus();
                    break;
                case 5:
                    StudentManagement.displayListStudent();
                    break;
                case 6:
                    StudentManagement.sortStudentByAvgMarkASC();
                    break;
                case 7:
                    StudentManagement.searchStudentByName();
                    break;
                case 8:
                    StudentManagement.studentStatistics();
                    break;
                case 9:
                    StudentManagement.statusStatistics();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-10");
            }
        } while (true);
    }

    public static void inputListStudent() {
        System.out.println("Nhập số sinh viên cần nhập thông tin: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ"+(i+1));
            Student student=new Student();
            student.inputData();
            studentList.add(student);
            displayListStudent();
        }
    }

    public static void calAvgMark() {
        for (Student student:studentList) {
         student.calAvgMark();
            System.out.println("Điểm trung bình của " + student.getStudentName() + ": " + student.calAvgMark());
        }
    }

    public static void calRank() {
        for (Student student:studentList) {
           student.calRank();
            System.out.println("Xếp loại của " + student.getStudentName() + ": " + student.getRank());
        }
    }

    public static void calStudentStatus() {
        for (Student student:studentList) {
           student.calStudentStatus();
            System.out.println("Trạng thái của " + student.getStudentName() + ": " + student.getStudentStatus());
        }
    }

    public static void displayListStudent() {
        for (Student student:studentList) {
          student.displayData();
            System.out.println();
        }
    }
    public static void sortStudentByAvgMarkASC() {
       studentList.sort(new Comparator<Student>() {
           @Override
           public int compare(Student studento1, Student studento2) {
               return Float.compare(studento1.calAvgMark(),studento2.calAvgMark());
           }
       });
        System.out.println("Danh sách sinh viên sắp xếp theo điểm trung bình:");
        for (Student student:studentList) {
         student.displayData();
            System.out.println();
        }
    }
    public static void searchStudentByName() {
        System.out.println("Nhập vào tên sinh viên cần tìm:");
        String searchName = scanner.nextLine();
        List<Student> searchStudentName=new ArrayList<>();
        for (Student student:studentList) {
         if(student.getStudentName().equalsIgnoreCase(searchName)){
             searchStudentName.add(student);
         }
        }
        if(!searchStudentName.isEmpty()){
            System.out.println("Danh sách sinh viên có tên '" + searchName + "':");
            for (Student student:searchStudentName) {
               student.displayData();
                System.out.println();
            }
        }else{
            System.err.println("Không tìm thấy sinh viên, vui lòng nhập lại.");
        }
    }

    public static void studentStatistics() {
        List<String> studentRankList=new ArrayList<>();
        for (Student student:studentList) {
          if(!studentRankList.contains(student.getRank())){
              studentRankList.add(student.getRank());
          }
        }
        System.out.println("Thống kê sinh viên theo xếp loại :");
        for (String rankList:studentRankList) {
         int cnt=0;
            for (Student student:studentList) {
             if(student.getRank().equals(studentRankList)){
                 cnt++;
             }
            }
            System.out.println(studentRankList+":"+cnt+"sinh viên");
        }
    }

    public static void statusStatistics() {
       List<String> statuses=new ArrayList<>();
        for (Student student:studentList) {
         if(!statuses.contains(student.getStudentStatus())){
             statuses.add(student.getStudentStatus());
         }
        }
        System.out.println("Thống kê sinh viên theo trạng thái :");
        for (String status:statuses) {
         int cnt=0;
            for (Student student:studentList) {
             if(student.getStudentStatus().equals(status)){
                 cnt++;
             }
            }
            System.out.println(status + ": " + cnt + " sinh viên");
        }
    }
}
