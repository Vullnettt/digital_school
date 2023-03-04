package com.zerogravitysolutuins.training_service.training;

import java.util.List;
import java.util.Optional;

public interface TrainingService {
    Training save(Training training);
    List<Training> findAll();
    Optional<Training> findById(Long id);
    Training update(Training training);
    Training disable(Long id);
    TrainingDto partialUpdate(Long id, TrainingDto trainingDto);
}
