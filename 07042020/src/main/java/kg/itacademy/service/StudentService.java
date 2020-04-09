package kg.itacademy.service;

import kg.itacademy.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();

    Optional<Student> getById(Long id);

    Student create(Student s);
}
