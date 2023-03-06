package com.example.studentservice.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path = "/students")
    public StudentDto addStudent(@RequestBody StudentDto studentDto){
        return studentService.save(studentDto);
    }

    @GetMapping(path = "/students")
    public List<StudentDto> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping(path = "/students/{id}")
    public Optional<StudentDto> getStudentById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @PutMapping(path = "/students/{id}")
    public StudentDto updateStudent(@RequestBody StudentDto studentDto){
        return studentService.update(studentDto);
    }

    @PutMapping(path = "/students/disable/{id}")
    public StudentDto disableStudent(@PathVariable Long id){
        return studentService.disable(id);
    }

    @PatchMapping(path = "/students/{id}")
    public StudentDto partialUpdate(@PathVariable Long id, @RequestBody StudentDto studentDto){
        return studentService.partialUpdate(id, studentDto);
    }
}
