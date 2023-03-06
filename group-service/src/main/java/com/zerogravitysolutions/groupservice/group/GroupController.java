package com.zerogravitysolutions.groupservice.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(path = "/groups")
    public GroupDto addGroup(@RequestBody GroupDto groupDto){
        return groupService.save(groupDto);
    }

    @GetMapping(path = "/groups")
    public List<GroupDto> getAllGroups(){
        return groupService.findAll();
    }

    @GetMapping(path = "/groups/{id}")
    public Optional<GroupDto> getGroupById(@PathVariable Long id){
        return groupService.findById(id);
    }

    @PutMapping(path = "/groups/{id}")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto){
        return groupService.update(groupDto);
    }
}
