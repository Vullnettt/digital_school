package com.zerogravitysolutions.groupservice.group;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    GroupDto save(GroupDto groupDto);
    List<GroupDto> findAll();
    Optional<GroupDto> findById(Long id);
    GroupDto update(GroupDto groupDto);
}
