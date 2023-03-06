package com.example.studentservice.student.utils;

import com.example.studentservice.student.Student;
import com.example.studentservice.student.StudentDto;

public class StudentMapper {

    public static Student mapDtoToEntity(StudentDto studentDto, Student student){

        if(studentDto.getId() != null){
            student.setId(studentDto.getId());
        }
        if(studentDto.getFirstName() != null){
            student.setFirstName(studentDto.getFirstName());
        }
        if(studentDto.getLastName() != null){
            student.setLastName(studentDto.getLastName());
        }
        if(studentDto.getEmail() != null){
            student.setEmail(studentDto.getEmail());
        }
        if(studentDto.getPhoneNumber() != null){
            student.setPhoneNumber(studentDto.getPhoneNumber());
        }
        if(studentDto.getPersonalNumber() != null){
            student.setPersonalNumber(studentDto.getPersonalNumber());
        }
        if(studentDto.getProfilePicture() != null){
            student.setProfilePicture(studentDto.getProfilePicture());
        }

        if(studentDto.getCreatedBy() != null){
            student.setCreatedBy(studentDto.getCreatedBy());
        }
        if(studentDto.getUpdatedAt() != null){
            student.setUpdatedAt(studentDto.getUpdatedAt());
        }
        if(studentDto.getUpdatedBy() != null){
            student.setUpdatedBy(studentDto.getUpdatedBy());
        }
        if(studentDto.getDeletedAt() != null){
            student.setDeletedAt(studentDto.getDeletedAt());
        }
        if(studentDto.getDeletedBy() != null){
            student.setDeletedBy(studentDto.getDeletedBy());
        }
        return student;
    }

    public static StudentDto mapEntityToDto(Student student) {

        StudentDto studentDto = new StudentDto();

        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setPhoneNumber(student.getPhoneNumber());
        studentDto.setPersonalNumber(student.getPersonalNumber());
        studentDto.setProfilePicture(student.getProfilePicture());

        studentDto.setCreatedAt(student.getCreatedAt());
        studentDto.setCreatedBy(student.getCreatedBy());
        studentDto.setUpdatedAt(student.getUpdatedAt());
        studentDto.setUpdatedBy(student.getUpdatedBy());
        studentDto.setDeletedAt(student.getDeletedAt());
        studentDto.setDeletedBy(student.getDeletedBy());

        return studentDto;
    }

}
