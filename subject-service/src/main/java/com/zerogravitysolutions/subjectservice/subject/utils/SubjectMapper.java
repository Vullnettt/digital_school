package com.zerogravitysolutions.subjectservice.subject.utils;

import com.zerogravitysolutions.subjectservice.subject.Subject;
import com.zerogravitysolutions.subjectservice.subject.SubjectDto;

public class SubjectMapper {


    public static Subject mapDtoToEntity(SubjectDto subjectDto, Subject subject){

        if(subjectDto.getId() != null){
            subject.setId(subjectDto.getId());
        }
        if(subjectDto.getTitle() != null){
            subject.setTitle(subjectDto.getTitle());
        }
        if(subjectDto.getDescription() != null){
            subject.setDescription(subjectDto.getDescription());
        }
        if(subjectDto.getCreatedAt() != null){
            subject.setCreatedAt(subjectDto.getCreatedAt());
        }
        if(subjectDto.getCreatedBy() != null){
            subject.setCreatedBy(subjectDto.getCreatedBy());
        }
        if(subjectDto.getUpdatedAt() != null){
            subject.setUpdatedAt(subjectDto.getUpdatedAt());
        }
        if(subjectDto.getUpdatedBy() != null){
            subject.setUpdatedBy(subjectDto.getUpdatedBy());
        }
        if(subjectDto.getDeletedAt() != null){
            subject.setDeletedAt(subjectDto.getDeletedAt());
        }
        if(subjectDto.getDeletedBy() != null){
            subject.setDeletedBy(subjectDto.getDeletedBy());
        }
        return subject;
    }

    public static SubjectDto mapEntityToDto(Subject subject) {

        SubjectDto subjectDto = new SubjectDto();

        subjectDto.setId(subject.getId());
        subjectDto.setTitle(subject.getTitle());
        subjectDto.setDescription(subject.getDescription());

        subjectDto.setCreatedAt(subject.getCreatedAt());
        subjectDto.setCreatedBy(subject.getCreatedBy());
        subjectDto.setUpdatedAt(subject.getUpdatedAt());
        subjectDto.setUpdatedBy(subject.getUpdatedBy());
        subjectDto.setDeletedAt(subject.getDeletedAt());
        subjectDto.setDeletedBy(subject.getDeletedBy());

        return subjectDto;
    }

}
