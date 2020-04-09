package kg.itacademy.service;

import kg.itacademy.entity.Student;
import kg.itacademy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student;
    }

    @Override
    public Student create(Student s) {
        return studentRepository.save(s);
    }
}
