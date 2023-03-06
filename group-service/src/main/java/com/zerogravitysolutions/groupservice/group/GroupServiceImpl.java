package com.zerogravitysolutions.groupservice.group;

import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
}
