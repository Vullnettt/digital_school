package com.zerogravitysolutions.subjectservice.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping(path = "/subjects")
    public SubjectDto addSubject(@RequestBody SubjectDto subjectDto){
        return subjectService.save(subjectDto);
    }

    @GetMapping(path = "/subjects")
    public List<SubjectDto> getAllSubjects(){
        return subjectService.findAll();
    }

    @GetMapping(path = "/subjects/{id}")
    public Optional<SubjectDto> getSubjectById(@PathVariable Long id){
        return subjectService.findById(id);
    }

    @PutMapping(path = "/subjects/{id}")
    public SubjectDto updateSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.update(subjectDto);
    }

    @PutMapping(path = "/subjects/disable/{id}")
    public SubjectDto disableSubject(@PathVariable Long id) {
        return subjectService.disable(id);
    }

    @PatchMapping(path = "/subjects/{id}")
    public SubjectDto partialUpdate(@PathVariable Long id, @RequestBody SubjectDto subjectDto) {
        return subjectService.partialUpdate(id, subjectDto);
    }
}
