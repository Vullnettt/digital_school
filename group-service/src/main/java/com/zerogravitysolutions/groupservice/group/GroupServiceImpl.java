package com.zerogravitysolutions.groupservice.group;

import com.zerogravitysolutions.groupservice.group.utils.GroupMapper;
import com.zerogravitysolutions.groupservice.template.instructor.Instructor;
import com.zerogravitysolutions.groupservice.template.training.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, RestTemplate restTemplate) {
        this.groupRepository = groupRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public GroupDto save(GroupDto groupDto) {
        Group group = new Group();
        Training training = restTemplate.getForObject("http://training-service:8081/trainings/" + groupDto.getTrainingId(), Training.class);
        GroupMapper.mapDtoToEntity(groupDto, group);
        group.setTraining(training);
        group.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        group.setCreatedBy(1L);
        return GroupMapper.mapEntityToDto(groupRepository.save(group));
    }

    @Override
    public List<GroupDto> findAll() {
        List<Group> groups = groupRepository.findAllGroup();
        return groups.stream().map(group -> GroupMapper.mapEntityToDto(group)).toList();
    }

    @Override
    public Optional<GroupDto> findById(Long id) {
        Optional<Group> group = groupRepository.findGroupById(id);
        if(group.isPresent()) {
            return Optional.of(GroupMapper.mapEntityToDto(group.get()));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group with id: " + group.get().getId() + " not found.");
        }
    }

    @Override
    public GroupDto update(GroupDto groupDto) {
        Group group = new Group();
        GroupMapper.mapDtoToEntity(groupDto, group);
        group.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        group.setUpdatedBy(1L);
        return GroupMapper.mapEntityToDto(groupRepository.save(group));
    }

    @Override
    public GroupDto disable(Long id) {
        Optional<Group> group = groupRepository.findGroupById(id);
        group.get().setDeletedAt(new Timestamp(System.currentTimeMillis()));
        group.get().setDeletedBy(1L);
        groupRepository.save(group.get());
        return GroupMapper.mapEntityToDto(groupRepository.findDisableGroup());
    }

    @Override
    public GroupDto partialUpdate(Long id, GroupDto groupDto) {
        Optional<Group> group = groupRepository.findGroupById(id);
        if(group.isPresent()){
            GroupMapper.mapDtoToEntity(groupDto, group.get());
            group.get().setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            group.get().setUpdatedBy(1L);
            return GroupMapper.mapEntityToDto(groupRepository.save(group.get()));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group with id: " + group.get().getId() + " not found.");
        }
    }

    @Override
    public GroupDto addInstructorInGroup(Long groupId, Long instructorId) {
        Optional<Group> group = groupRepository.findGroupById(groupId);
        if(group.isPresent()) {
            Instructor instructor = restTemplate.getForObject("http://instructor-service:8082/instructors/" + instructorId, Instructor.class);
            group.get().getInstructors().add(instructor);
            return GroupMapper.mapEntityToDto(groupRepository.save(group.get()));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Group with id: " + group.get().getId() + " not found.");
        }
    }
}
