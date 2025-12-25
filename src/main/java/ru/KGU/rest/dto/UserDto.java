package ru.KGU.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class UserDto {
    private String id;
    private String name;
    private String password;

    private String publicKeyForInvitation;

    private String recoveryPassword;

    private List<UserGroupDto> userGroupDtos;

}
