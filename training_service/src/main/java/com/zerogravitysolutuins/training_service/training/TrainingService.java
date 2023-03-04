package com.zerogravitysolutuins.training_service.training;

import java.util.List;
import java.util.Optional;

public interface TrainingService {
    TrainingDto save(TrainingDto trainingDto);
    List<TrainingDto> findAll();
    Optional<TrainingDto> findById(Long id);
    TrainingDto update(TrainingDto trainingDto);
    TrainingDto disable(Long id);
    TrainingDto partialUpdate(Long id, TrainingDto trainingDto);
    TrainingDto addInstructorToTraining(Long trainingId, Long instructorId);
}
