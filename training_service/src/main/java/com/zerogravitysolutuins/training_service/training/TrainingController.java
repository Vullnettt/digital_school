package com.zerogravitysolutuins.training_service.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainingController {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingController(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }
}
