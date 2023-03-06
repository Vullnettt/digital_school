package com.zerogravitysolutions.groupservice.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("Select g From Group As g Where g.deletedAt <> null")
    Group findDisableGroup();

    @Query("Select g From Group As g Where g.deletedAt = null")
    List<Group> findAllGroup();

    @Query("Select g From Group As g Where g.deletedAt = null And g.id = ?1")
    Optional<Group> findGroupById(Long id);


}
