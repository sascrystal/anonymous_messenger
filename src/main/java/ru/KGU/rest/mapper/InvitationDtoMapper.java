package ru.KGU.rest.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.KGU.domain.Invitation;
import ru.KGU.domain.InvitationId;
import ru.KGU.rest.dto.InvitationDto;

@RequiredArgsConstructor
@Component
public class InvitationDtoMapper {
    private final UserDtoMapper userDtoMapper;
    private final GroupDtoMapper groupDtoMapper;

    public InvitationDto toDto(Invitation invitation) {
        return InvitationDto.builder()
                .host(userDtoMapper.toDto(invitation.getHost()))
                .user(userDtoMapper.toDto(invitation.getUser()))
                .group(groupDtoMapper.toDto(invitation.getGroup()))
                .publicKey(invitation.getPublicKeyForGroup())
                .privateKey(invitation.getPrivateKeyForGroup()).build();

    }
    public Invitation toDomainObject(InvitationDto invitationDto) {
        return Invitation.builder()
                .host(userDtoMapper.toDomainObject(invitationDto.getHost()))
                .user(userDtoMapper.toDomainObject(invitationDto.getUser()))
                .group(groupDtoMapper.toDomainObject(invitationDto.getGroup()))
                .publicKeyForGroup(invitationDto.getPublicKey())
                .privateKeyForGroup(invitationDto.getPrivateKey()).build();
    }
}
