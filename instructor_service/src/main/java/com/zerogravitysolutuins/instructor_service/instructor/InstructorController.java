package com.zerogravitysolutuins.instructor_service.instructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping(path = "/instructors")
    public InstructorDto addInstructor(@RequestBody InstructorDto instructorDto){
        return instructorService.save(instructorDto);
    }

    @GetMapping(path = "/instructors")
    public List<InstructorDto> getAllInstructors(){
        return instructorService.findAll();
    }

    @GetMapping(path = "/instructors/{id}")
    public Optional<InstructorDto> getInstructorById(@PathVariable Long id){
        return instructorService.findById(id);
    }

    @PutMapping(path = "/instructors/{id}")
    public InstructorDto updateInstructor(@RequestBody InstructorDto instructorDto){
        return instructorService.update(instructorDto);
    }

    @PutMapping(path = "/instructors/disable/{id}")
    public InstructorDto disableInstructor(@PathVariable Long id){
        return instructorService.disable(id);
    }

    @PatchMapping(path = "/instructors/{id}")
    public InstructorDto partialUpdate(@PathVariable Long id, @RequestBody InstructorDto instructorDto){
        return instructorService.partialUpdate(id, instructorDto);
    }
}
