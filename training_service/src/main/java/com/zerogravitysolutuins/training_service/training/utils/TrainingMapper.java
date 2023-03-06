package com.zerogravitysolutuins.training_service.training.utils;

import com.zerogravitysolutuins.training_service.training.Training;
import com.zerogravitysolutuins.training_service.training.TrainingDto;

public class TrainingMapper {

    public static Training mapDtoToEntity(TrainingDto trainingDto, Training training){

        if(trainingDto.getId() != null){
            training.setId(trainingDto.getId());
        }
        if(trainingDto.getTitle() != null){
            training.setTitle(trainingDto.getTitle());
        }
        if(trainingDto.getDescription() != null){
            training.setDescription(trainingDto.getDescription());
        }
        if(trainingDto.getPrice() != null){
            training.setPrice(trainingDto.getPrice());
        }

        if(trainingDto.getCreatedAt() != null){
            training.setCreatedAt(trainingDto.getCreatedAt());
        }
        if(trainingDto.getCreatedBy() != null){
            training.setCreatedBy(trainingDto.getCreatedBy());
        }
        if(trainingDto.getUpdatedAt() != null){
            training.setUpdatedAt(trainingDto.getUpdatedAt());
        }
        if(trainingDto.getUpdatedBy() != null){
            training.setUpdatedBy(trainingDto.getUpdatedBy());
        }
        if(trainingDto.getDeletedAt() != null){
            training.setDeletedAt(trainingDto.getDeletedAt());
        }
        if(trainingDto.getDeletedBy() != null){
            training.setDeletedBy(trainingDto.getDeletedBy());
        }
        return training;
    }

    public static TrainingDto mapEntityToDto(Training training) {

        TrainingDto trainingDto = new TrainingDto();

        trainingDto.setId(training.getId());
        trainingDto.setTitle(training.getTitle());
        trainingDto.setDescription(training.getDescription());
        trainingDto.setPrice(training.getPrice());
        trainingDto.setInstructors(training.getInstructors());
        trainingDto.setSubjects(training.getSubjects());
        trainingDto.setGroups(training.getGroups());

        trainingDto.setCreatedAt(training.getCreatedAt());
        trainingDto.setCreatedBy(training.getCreatedBy());
        trainingDto.setUpdatedAt(training.getUpdatedAt());
        trainingDto.setUpdatedBy(training.getUpdatedBy());
        trainingDto.setDeletedAt(training.getDeletedAt());
        trainingDto.setDeletedBy(training.getDeletedBy());

        return trainingDto;
    }
}
