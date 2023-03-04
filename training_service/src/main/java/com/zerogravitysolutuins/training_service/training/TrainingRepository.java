package com.zerogravitysolutuins.training_service.training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    @Query("Select t From Training As t Where t.deletedAt <> null")
    Training getDisableTraining();

    @Query("Select t From Training As t Where t.deletedAt = null")
    List<Training> findAllTraining();

    @Query("Select t From Training As t Where t.deletedAt = null And t.id = ?1")
    Optional<Training> findTrainingById(Long id);
}
