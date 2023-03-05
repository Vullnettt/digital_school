package com.zerogravitysolutuins.instructor_service.instructor.utils;

import com.zerogravitysolutuins.instructor_service.instructor.Instructor;
import com.zerogravitysolutuins.instructor_service.instructor.InstructorDto;

public class InstructorMapper {

    public static Instructor mapDtoToEntity(InstructorDto instructorDto, Instructor instructor){

        if(instructorDto.getId() != null){
            instructor.setId(instructorDto.getId());
        }
        if(instructorDto.getFirstName() != null){
            instructor.setFirstName(instructorDto.getFirstName());
        }
        if(instructorDto.getLastName() != null){
            instructor.setLastName(instructorDto.getLastName());
        }
        if(instructorDto.getEmail() != null){
            instructor.setEmail(instructorDto.getEmail());
        }
        if(instructorDto.getPhoneNumber() != null){
            instructor.setPhoneNumber(instructorDto.getPhoneNumber());
        }
        if(instructorDto.getBio() != null){
            instructor.setBio(instructorDto.getBio());
        }
        if(instructorDto.getFacebookProfile() != null){
            instructor.setFacebookProfile(instructorDto.getFacebookProfile());
        }
        if(instructorDto.getLinkedinProfile() != null){
            instructor.setLinkedinProfile(instructorDto.getLinkedinProfile());
        }
        if(instructorDto.getProfilePicture() != null){
            instructor.setProfilePicture(instructorDto.getProfilePicture());
        }

        if(instructorDto.getCreatedAt() != null){
            instructor.setCreatedAt(instructorDto.getCreatedAt());
        }
        if(instructorDto.getCreatedBy() != null){
            instructor.setCreatedBy(instructorDto.getCreatedBy());
        }
        if(instructorDto.getUpdatedAt() != null){
            instructor.setUpdatedAt(instructorDto.getUpdatedAt());
        }
        if(instructorDto.getUpdatedBy() != null){
            instructor.setUpdatedBy(instructorDto.getUpdatedBy());
        }
        if(instructorDto.getDeletedAt() != null){
            instructor.setDeletedAt(instructorDto.getDeletedAt());
        }
        if(instructorDto.getDeletedBy() != null){
            instructor.setDeletedBy(instructorDto.getDeletedBy());
        }
        return instructor;
    }

    public static InstructorDto mapEntityToDto(Instructor instructor) {

        InstructorDto instructorDto = new InstructorDto();

        instructorDto.setId(instructor.getId());
        instructorDto.setFirstName(instructor.getFirstName());
        instructorDto.setLastName(instructor.getLastName());
        instructorDto.setEmail(instructor.getEmail());
        instructorDto.setPhoneNumber(instructor.getPhoneNumber());
        instructorDto.setBio(instructor.getBio());
        instructorDto.setFacebookProfile(instructor.getFacebookProfile());
        instructorDto.setLinkedinProfile(instructor.getLinkedinProfile());
        instructorDto.setProfilePicture(instructor.getProfilePicture());
        instructorDto.setTrainings(instructor.getTrainings());

        instructorDto.setCreatedAt(instructor.getCreatedAt());
        instructorDto.setCreatedBy(instructor.getCreatedBy());
        instructorDto.setUpdatedAt(instructor.getUpdatedAt());
        instructorDto.setUpdatedBy(instructor.getUpdatedBy());
        instructorDto.setDeletedAt(instructor.getDeletedAt());
        instructorDto.setDeletedBy(instructor.getDeletedBy());

        return instructorDto;
    }
}
