package ru.polina.edutrack.repository;

import ru.polina.edutrack.model.Student;

import java.util.List;

public interface StudentRepository {

    boolean addStudent(Student student) ;
    List<Student> getAllStudents();
    Student findById(int id);
}
