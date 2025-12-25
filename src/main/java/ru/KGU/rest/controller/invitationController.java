package ru.KGU.rest.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.query.InvalidJpaQueryMethodException;
import org.springframework.web.bind.annotation.*;
import ru.KGU.domain.Invitation;
import ru.KGU.rest.dto.InvitationDto;
import ru.KGU.rest.mapper.InvitationDtoMapper;
import ru.KGU.service.InvitationService;
import ru.KGU.service.UserService;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor

public class invitationController {
    private  final   InvitationService invitationService;
    private final InvitationDtoMapper invitationDtoMapper;

    @PostMapping("/user/{id}/invitation")
    public InvitationDto createInvitation (@RequestBody InvitationDto invitationDto, @PathVariable String id) {
        if(!Objects.equals(invitationDto.getHostId(), id)){
            return null;
        }
        Invitation invitation = invitationDtoMapper.toDomainObject(invitationDto);
        return invitationDtoMapper.toDto(invitationService.createInvitation(invitation));
    }

    @GetMapping("/user/{id}/invitation/all")
    public List<InvitationDto> getAllInvitations (@PathVariable String id) {
        return invitationService.getInvitationsByUserId(id).stream().map(invitationDtoMapper::toDto).toList();
    }
    @GetMapping("/user/{id}/invitation/allSent")
    public List<InvitationDto> getAllSentInvitations (@PathVariable String id) {
        return invitationService.getSentInvitationsByUserId(id).stream().map(invitationDtoMapper::toDto).toList();
    }

}
