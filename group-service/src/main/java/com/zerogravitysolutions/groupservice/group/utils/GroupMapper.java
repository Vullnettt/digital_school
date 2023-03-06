package com.zerogravitysolutions.groupservice.group.utils;

import com.zerogravitysolutions.groupservice.group.Group;
import com.zerogravitysolutions.groupservice.group.GroupDto;

public class GroupMapper {

    public static Group mapDtoToEntity(GroupDto groupDto, Group group){

        if(groupDto.getId() != null){
            group.setId(groupDto.getId());
        }
        if(groupDto.getTitle() != null){
            group.setTitle(groupDto.getTitle());
        }
        if(groupDto.getDescription() != null){
            group.setDescription(groupDto.getDescription());
        }
        if(groupDto.getStartDate() != null){
            group.setStartDate(groupDto.getStartDate());
        }
        if(groupDto.getEndDate() != null){
            group.setEndDate(groupDto.getEndDate());
        }

        if(groupDto.getCreatedAt() != null){
            group.setCreatedAt(groupDto.getCreatedAt());
        }
        if(groupDto.getCreatedBy() != null){
            group.setCreatedBy(groupDto.getCreatedBy());
        }
        if(groupDto.getUpdatedAt() != null){
            group.setUpdatedAt(groupDto.getUpdatedAt());
        }
        if(groupDto.getUpdatedBy() != null){
            group.setUpdatedBy(groupDto.getUpdatedBy());
        }
        if(groupDto.getDeletedAt() != null){
            group.setDeletedAt(groupDto.getDeletedAt());
        }
        if(groupDto.getDeletedBy() != null){
            group.setDeletedBy(groupDto.getDeletedBy());
        }
        return group;
    }

    public static GroupDto mapEntityToDto(Group group) {

        GroupDto groupDto = new GroupDto();

        groupDto.setId(group.getId());
        groupDto.setTitle(group.getTitle());
        groupDto.setDescription(group.getDescription());
        groupDto.setStartDate(group.getStartDate());
        groupDto.setEndDate(group.getEndDate());
        groupDto.setTrainingId(group.getTraining().getId());

        groupDto.setCreatedAt(group.getCreatedAt());
        groupDto.setCreatedBy(group.getCreatedBy());
        groupDto.setUpdatedAt(group.getUpdatedAt());
        groupDto.setUpdatedBy(group.getUpdatedBy());
        groupDto.setDeletedAt(group.getDeletedAt());
        groupDto.setDeletedBy(group.getDeletedBy());

        return groupDto;
    }
}
