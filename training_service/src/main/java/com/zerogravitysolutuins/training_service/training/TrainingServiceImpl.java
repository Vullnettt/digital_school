package com.zerogravitysolutuins.training_service.training;

import com.zerogravitysolutuins.training_service.training.utils.TrainingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    @Override
    public TrainingDto partialUpdate(Long id, TrainingDto trainingDto) {
        Optional<Training> training = trainingRepository.findTrainingById(id);
        if(training.isPresent()){
            TrainingMapper.mapDtoToEntity(trainingDto, training.get());
            training.get().setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            training.get().setUpdatedBy(1L);
            return TrainingMapper.mapEntityToDto(trainingRepository.save(training.get()));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Training with id: " + training.get().getId() + " not found.");
        }
    }
}
