package ru.KGU.service;

import ru.KGU.domain.Invitation;
import ru.KGU.domain.InvitationId;
import ru.KGU.repository.InvitationRepository;

public class InvitationServiceImpl implements InvitationService {
    private InvitationRepository invitationRepository;

    @Override
    public Invitation getInvitationService(InvitationId invitationId) {
        return invitationRepository.findByHostAndUserAndGroup(invitationId.getHost(),invitationId.getUser(),invitationId.getGroup());
    }

    @Override
    public Invitation createInvitation(Invitation invitation) {
        return invitationRepository.save(invitation);
    }

    @Override
    public Invitation updateInvitation(Invitation invitation) {
        return invitationRepository.save(invitation);
    }

    @Override
    public void deleteInvitation(InvitationId invitationId) {
        invitationRepository.deleteByHostAndUserAndGroup(invitationId.getHost(),invitationId.getUser(),invitationId.getGroup());

    }
}
