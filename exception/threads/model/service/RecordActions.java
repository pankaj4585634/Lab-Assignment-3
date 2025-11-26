package service;

import exception.StudentNotFoundException;
import model.Student;

public interface RecordActions {
    void addStudent(Student s);
    void searchStudent(Integer rollNo) throws StudentNotFoundException;
    void viewAllStudents();
}
