import java.util.*;
import model.Student;
import service.StudentManager;
import exception.StudentNotFoundException;

public class MainApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("===== Student Management System (Lab 3) =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. View All Students");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    try {
                        System.out.print("Enter Roll No (Integer): ");
                        Integer r = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks (Double): ");
                        Double marks = sc.nextDouble();

                        if (marks < 0 || marks > 100)
                            throw new IllegalArgumentException("Marks must be between 0 and 100!");

                        manager.addStudent(new Student(r, name, email, course, marks));

                    } catch (Exception e) {
                        System.out.println("Invalid Input: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll No to Search: ");
                    try {
                        manager.searchStudent(sc.nextInt());
                    } catch (StudentNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    manager.viewAllStudents();
                    break;

                case 4:
                    System.out.println("Program execution completed.");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
