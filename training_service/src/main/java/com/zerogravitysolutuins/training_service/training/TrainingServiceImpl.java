package com.zerogravitysolutuins.training_service.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public Training save(Training training) {
        training.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        training.setCreatedBy(1L);
        return trainingRepository.save(training);
    }

    @Override
    public List<Training> findAll() {
        return trainingRepository.findAllTraining();
    }

    @Override
    public Optional<Training> findById(Long id) {
        return trainingRepository.findTrainingById(id);
    }

    @Override
    public Training update(Training training) {
        training.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        training.setUpdatedBy(1L);
        return trainingRepository.save(training);
    }

    @Override
    public Training disable(Long id) {
        Optional<Training> training = trainingRepository.findTrainingById(id);
        training.get().setDeletedAt(new Timestamp(System.currentTimeMillis()));
        training.get().setDeletedBy(1L);
        trainingRepository.save(training.get());
        return trainingRepository.getDisableTraining();
    }
}
