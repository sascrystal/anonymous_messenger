package ru.KGU.service;

import ru.KGU.domain.Invitation;
import ru.KGU.domain.InvitationId;

import java.util.List;

public interface InvitationService {
    List<Invitation> getInvitationsByUserId(String userId);

    List<Invitation> getSentInvitationsByUserId(String userId);

    Invitation createInvitation(Invitation invitation);

    Invitation updateInvitation(Invitation invitation);

    void deleteInvitation(InvitationId invitationId);
}
