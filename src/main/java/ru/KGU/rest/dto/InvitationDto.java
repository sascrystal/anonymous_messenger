package ru.KGU.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.KGU.domain.Group;
import ru.KGU.domain.User;

@AllArgsConstructor
@Data
@Builder
public class InvitationDto {
    private UserDto host;
    private UserDto user;
    private GroupDto group;
    private String publicKey;
    private String privateKey;
}
