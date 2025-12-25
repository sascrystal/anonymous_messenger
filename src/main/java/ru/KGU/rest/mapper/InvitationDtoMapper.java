package ru.KGU.rest.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.KGU.domain.Invitation;
import ru.KGU.domain.InvitationId;
import ru.KGU.rest.dto.InvitationDto;
import ru.KGU.service.GroupService;
import ru.KGU.service.UserService;

@RequiredArgsConstructor
@Component
public class InvitationDtoMapper {
    private final UserDtoMapper userDtoMapper;
    private final GroupDtoMapper groupDtoMapper;
    private final UserService userService;
    private final GroupService groupService;

    public InvitationDto toDto(Invitation invitation) {
        return InvitationDto.builder()
                .hostId(invitation.getHost().getId())
                .newUserId(invitation.getUser().getId())
                .groupId(invitation.getGroup().getId())
                .publicKey(invitation.getPublicKeyForGroup())
                .privateKey(invitation.getPrivateKeyForGroup()).build();

    }
    public Invitation toDomainObject(InvitationDto invitationDto) {
        return Invitation.builder()
                .host(userService.getUser(invitationDto.getHostId()))
                .user(userService.getUser(invitationDto.getNewUserId()))
                .group(groupService.getGroup(invitationDto.getGroupId()))
                .publicKeyForGroup(invitationDto.getPublicKey())
                .privateKeyForGroup(invitationDto.getPrivateKey()).build();
    }
}
