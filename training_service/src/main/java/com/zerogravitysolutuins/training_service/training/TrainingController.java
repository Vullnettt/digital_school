package com.zerogravitysolutuins.training_service.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrainingController {

    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping(path = "/trainings")
    private Training addTraining(@RequestBody Training training){
        return trainingService.save(training);
    }

    @GetMapping(path = "/trainings")
    public List<Training> getAllTraining(){
        return trainingService.findAll();
    }

    @GetMapping(path = "/trainings/{id}")
    public Optional<Training> findTrainingById(@PathVariable Long id){
        return trainingService.findById(id);
    }

    @PutMapping(path = "/trainings/{id}")
    public Training updateTraining(@RequestBody Training training){
        return trainingService.update(training);
    }
}
