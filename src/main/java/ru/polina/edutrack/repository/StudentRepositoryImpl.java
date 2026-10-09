package ru.polina.edutrack.repository;

import org.springframework.stereotype.Repository;
import ru.polina.edutrack.model.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

    private final List<Student> students = new ArrayList<>();


    @Override
    public boolean addStudent(Student student) {
        if(findById(student.getId()) != null){
            return false;
        }
        return students.add(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public Student findById(int id) {

        for(Student s : students) {
            if(s.getId() == id)
                return s;
        }
        return null;
    }
}
