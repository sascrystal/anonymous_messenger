package ru.KGU.rest.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.KGU.domain.Group;
import ru.KGU.domain.UserGroup;
import ru.KGU.rest.dto.GroupDto;
import ru.KGU.rest.dto.UserGroupDto;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class GroupDtoMapper {
    private final UserGroupDtoMapper userGroupDtoMapper;

    public GroupDto toDto(Group group) {
        if (group.getUsers() == null) {
            return new GroupDto(
                    group.getId(),
                    group.getName(),
                    group.getDescription(),
                    null
            );
        }

        List<UserGroupDto> userGroupDtos = group.getUsers().stream().map(userGroupDtoMapper::toDto).toList();
        return new GroupDto(
                group.getId(),
                group.getName(),
                group.getDescription(),
                userGroupDtos
        );
    }

    public Group toDomainObject(GroupDto groupDto) {
        if(groupDto.getUserGroupsDto() == null) {
            return Group.builder()
                    .id(groupDto.getId())
                    .name(groupDto.getName())
                    .description(groupDto.getDescription())
                    .build();
        }
        List<UserGroup> userGroups  =groupDto.getUserGroupsDto().stream().map(userGroupDtoMapper::toDomainObject).toList();
        return Group.builder()
                .id(groupDto.getId())
                .name(groupDto.getName())
                .description(groupDto.getDescription())
                .users(userGroups)
                .build();
    }
}
