package com.example.studentservice.student;

import com.example.studentservice.student.utils.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = new Student();
        StudentMapper.mapDtoToEntity(studentDto, student);
        student.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        student.setCreatedBy(1L);
        return StudentMapper.mapEntityToDto(studentRepository.save(student));
    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentRepository.findAllStudent();
        return students.stream().map(student -> StudentMapper.mapEntityToDto(student)).toList();
    }

    @Override
    public Optional<StudentDto> findById(Long id) {
        Optional<Student> student = studentRepository.findStudentById(id);
        if(student.isPresent()) {
            return Optional.of(StudentMapper.mapEntityToDto(student.get()));
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id: " + student.get().getId() + " not found.");
        }
    }
}
