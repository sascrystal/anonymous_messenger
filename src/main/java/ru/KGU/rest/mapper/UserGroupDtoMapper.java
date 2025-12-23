package ru.KGU.rest.mapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.KGU.domain.UserGroup;
import ru.KGU.rest.dto.UserGroupDto;
import ru.KGU.service.GroupService;
import ru.KGU.service.UserGroupService;
import ru.KGU.service.UserService;

@RequiredArgsConstructor
@Component
public class UserGroupDtoMapper {
    private final UserService userService;
    private final GroupService groupService;
    private final UserTypeDtoMapper userTypeDtoMapper;

    public UserGroupDto toDto(UserGroup userGroup) {
        return new UserGroupDto(
                userGroup.getGroup().getId(),
                userGroup.getUser().getId(),
                userTypeDtoMapper.toDto(userGroup.getUserType()));
    }

    public  UserGroup toDomainObject(UserGroupDto userGroupDto) {
        return UserGroup.builder()
                .group(groupService.getGroup(userGroupDto.getGroupId()))
                .user(userService.getUser(userGroupDto.getUserId()))
                .userType(userTypeDtoMapper.toDomainObject(userGroupDto.getUserTypeDto()))
                .build();

    }
}
