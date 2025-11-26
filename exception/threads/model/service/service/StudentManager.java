package service;

import java.util.*;
import exception.StudentNotFoundException;
import model.Student;
import threads.Loader;

public class StudentManager implements RecordActions {

    private Map<Integer, Student> studentMap = new HashMap<>();

    @Override
    public void addStudent(Student s) {
        try {
            if (s == null) throw new NullPointerException("Student object is null!");

            if (s.getRollNo() <= 0)
                throw new IllegalArgumentException("Roll number must be positive!");

            if (sMap.containsKey(s.getRollNo()))
                throw new IllegalArgumentException("Duplicate roll number not allowed!");

            // loading simulation
            Thread t = new Thread(new Loader());
            t.start();
            t.join();

            studentMap.put(s.getRollNo(), s);
            System.out.println("Student added successfully!");

        } catch (Exception e) {
            System.out.println("Error Adding Student: " + e.getMessage());
        }
    }

    @Override
    public void searchStudent(Integer rollNo) throws StudentNotFoundException {
        if (!studentMap.containsKey(rollNo))
            throw new StudentNotFoundException("Student with Roll No " + rollNo + " not found!");

        studentMap.get(rollNo).display();
    }

    @Override
    public void viewAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No records found!");
            return;
        }
        for (Student s : studentMap.values()) {
            s.display();
        }
    }
}
