package kg.itacademy.controller;

import kg.itacademy.entity.Student;
import kg.itacademy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }
}
