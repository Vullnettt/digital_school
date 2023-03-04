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
    private TrainingDto addTraining(@RequestBody TrainingDto trainingDto){
        return trainingService.save(trainingDto);
    }

    @GetMapping(path = "/trainings")
    public List<TrainingDto> getAllTraining(){
        return trainingService.findAll();
    }

    @GetMapping(path = "/trainings/{id}")
    public Optional<TrainingDto> findTrainingById(@PathVariable Long id){
        return trainingService.findById(id);
    }

    @PutMapping(path = "/trainings/{id}")
    public TrainingDto updateTraining(@RequestBody TrainingDto trainingDto){
        return trainingService.update(trainingDto);
    }

    @PutMapping(path = "/trainings/disable/{id}")
    public TrainingDto disableTraining(@PathVariable Long id){
        return trainingService.disable(id);
    }

    @PatchMapping(path = "/trainings/{id}")
    public TrainingDto partialUpdate(@PathVariable Long id, @RequestBody TrainingDto trainingDto){
        return trainingService.partialUpdate(id, trainingDto);
    }

    @PutMapping(path = "/trainings/{trainingId}/instructors/{instructorId}")
    public TrainingDto addInstructorToTraining(@PathVariable Long trainingId, @PathVariable Long instructorId){
        return trainingService.addInstructorToTraining(trainingId, instructorId);
    }
}
