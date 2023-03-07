package com.example.studentservice.student;

import com.example.studentservice.template.group.Group;
import com.example.studentservice.student.utils.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final RestTemplate restTemplate;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, RestTemplate restTemplate) {
        this.studentRepository = studentRepository;
        this.restTemplate = restTemplate;
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

    @Override
    public StudentDto update(StudentDto studentDto) {
        Student student = new Student();
        StudentMapper.mapDtoToEntity(studentDto, student);
        student.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        student.setUpdatedBy(1L);
        return StudentMapper.mapEntityToDto(studentRepository.save(student));
    }

    @Override
    public StudentDto disable(Long id) {
        Optional<Student> student = studentRepository.findStudentById(id);
        student.get().setDeletedAt(new Timestamp(System.currentTimeMillis()));
        student.get().setDeletedBy(1L);
        studentRepository.save(student.get());
        return StudentMapper.mapEntityToDto(studentRepository.findDisableStudent());
    }

    @Override
    public StudentDto partialUpdate(Long id, StudentDto studentDto) {
        Optional<Student> student = studentRepository.findStudentById(id);

        if(student.isPresent()) {
            StudentMapper.mapDtoToEntity(studentDto, student.get());
            student.get().setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            student.get().setUpdatedBy(1L);
            return StudentMapper.mapEntityToDto(studentRepository.save(student.get()));
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id: " + student.get().getId() + " not found.");
        }
    }

    @Override
    public StudentDto addStudentToGroup(Long studentId, Long groupId) {
        Optional<Student> student = studentRepository.findStudentById(studentId);
        if(student.isPresent()) {
            Group group = restTemplate.getForObject("http://localhost:8085/groups/" + groupId, Group.class);
            student.get().getGroups().add(group);
            return StudentMapper.mapEntityToDto(studentRepository.save(student.get()));
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id: " + student.get().getId() + " not found.");
        }
    }
}
