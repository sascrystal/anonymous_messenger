package ru.KGU.rest.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.KGU.domain.User;
import ru.KGU.domain.UserGroup;
import ru.KGU.rest.dto.UserDto;
import ru.KGU.rest.dto.UserGroupDto;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserDtoMapper {
    private final UserGroupDtoMapper userGroupDtoMapper;

    public UserDto toDto(User user) {
        List<UserGroupDto> userGroupDtos = user.getGroups().stream().map(userGroupDtoMapper::toDto).toList();
        return  UserDto.builder().id(user.getId()).name(user.getName()).userGroupDtos(userGroupDtos).build();


    }
    public User toDomainObject(UserDto userDto) {
        List<UserGroup> userGroups = userDto.getUserGroupDtos().stream().map(userGroupDtoMapper::toDomainObject).toList();
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .groups(userGroups)
                .password(userDto.getPassword())
                .recoveryPassword(userDto.getRecoveryPassword())
                .publicKeyForInvitation(userDto.getPublicKeyForInvitation()).build();
    }

}
