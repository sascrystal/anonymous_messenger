package ru.KGU.rest.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.query.InvalidJpaQueryMethodException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.KGU.domain.Invitation;
import ru.KGU.rest.dto.InvitationDto;
import ru.KGU.rest.mapper.InvitationDtoMapper;
import ru.KGU.service.InvitationService;
import ru.KGU.service.UserService;

import java.util.Objects;

@RestController
@RequiredArgsConstructor

public class invitationController {
    private  final   InvitationService invitationService;
    private final InvitationDtoMapper invitationDtoMapper;
    private final UserService userService;

    @PostMapping("/user/{id}/invitation")
    public InvitationDto createInvitation (@RequestBody InvitationDto invitationDto, @PathVariable String id) {
        if(!Objects.equals(invitationDto.getHostId(), id)){
            return null;
        }
        Invitation invitation = invitationDtoMapper.toDomainObject(invitationDto);
        return invitationDtoMapper.toDto(invitationService.createInvitation(invitation));
    }
}
