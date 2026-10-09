package ru.polina.edutrack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.polina.edutrack.model.Student;
import ru.polina.edutrack.repository.StudentRepository;

import java.util.List;

@Component ("student_service_id")
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }


    public void printWelcomeMessage(){
        System.out.println("Hello dear student!");
    }

    public boolean addStudent(Student student){
        return repository.addStudent(student);
    }

    public List<Student> getAllStudents(){
        return repository.getAllStudents();
    }

    public Student findById(int id){
        return repository.findById(id);
    }




}
