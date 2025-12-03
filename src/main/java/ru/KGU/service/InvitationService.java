package ru.KGU.service;

import org.hibernate.sql.Update;
import ru.KGU.domain.Invitation;
import ru.KGU.domain.InvitationId;

public interface InvitationService {
    Invitation getInvitationService(InvitationId invitationId);
    Invitation createInvitation(Invitation invitation);
    Invitation updateInvitation(Invitation invitation);
    void deleteInvitation(InvitationId invitationId);
}
