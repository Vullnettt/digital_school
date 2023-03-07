package com.zerogravitysolutuins.instructor_service.instructor;

import com.zerogravitysolutuins.instructor_service.instructor.utils.InstructorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService{

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public InstructorDto save(InstructorDto instructorDto) {
        Instructor instructor = new Instructor();
        InstructorMapper.mapDtoToEntity(instructorDto, instructor);
        instructor.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        instructor.setCreatedBy(1L);
        return InstructorMapper.mapEntityToDto(instructorRepository.save(instructor));
    }

    @Override
    public List<InstructorDto> findAll() {
        List<Instructor> instructors = instructorRepository.findAllInstructor();
        return instructors.stream().map(instructor -> InstructorMapper.mapEntityToDto(instructor)).toList();
    }

    @Override
    public Optional<InstructorDto> findById(Long id) {
        Optional<Instructor> instructor = instructorRepository.findInstructorById(id);
        if(instructor.isPresent()){
            return Optional.of(InstructorMapper.mapEntityToDto(instructor.get()));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor with id: " + instructor.get().getId() + " not found.");
    }

    @Override
    public InstructorDto update(InstructorDto instructorDto) {
        Instructor instructor = new Instructor();
        InstructorMapper.mapDtoToEntity(instructorDto, instructor);
        instructor.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        instructor.setUpdatedBy(1L);
        return InstructorMapper.mapEntityToDto(instructorRepository.save(instructor));
    }

    @Override
    public InstructorDto disable(Long id) {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        if(instructor.isPresent()) {
            instructor.get().setDeletedAt(new Timestamp(System.currentTimeMillis()));
            instructor.get().setDeletedBy(1L);
            instructorRepository.save(instructor.get());
            return InstructorMapper.mapEntityToDto(instructorRepository.getDisabledInstructor());
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor with id: " + instructor.get().getId() + " not found.");
        }
    }

    @Override
    public InstructorDto partialUpdate(Long id, InstructorDto instructorDto) {
        Optional<Instructor> instructor = instructorRepository.findInstructorById(id);
        if(instructor.isPresent()) {
            InstructorMapper.mapDtoToEntity(instructorDto, instructor.get());
            instructor.get().setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            instructor.get().setUpdatedBy(1L);
            return InstructorMapper.mapEntityToDto(instructorRepository.save(instructor.get()));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instructor with id: " + instructor.get().getId() + " not found.");
        }
    }
}
