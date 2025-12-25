package ru.KGU.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.KGU.domain.*;
import ru.KGU.repository.InvitationRepository;
@Service
@AllArgsConstructor
public class InvitationServiceImpl implements InvitationService {
    private final InvitationRepository invitationRepository;
    private final UserGroupService userGroupService;
    private final UserService userService;
    private final GroupService groupService;
    private final  UserTypeService userTypeService;

    @Override
    public Invitation getInvitationService(InvitationId invitationId) {
        return invitationRepository.findByHostAndUserAndGroup(invitationId.getHost(),invitationId.getUser(),invitationId.getGroup());
    }

    @Override
    public Invitation createInvitation(Invitation invitation) {
        UserGroup userGroupHost = userGroupService.getUserGroup(new UserGroupId(invitation.getGroup(),invitation.getHost()));
        UserGroup userGroupNewUser = userGroupService.getUserGroup(new UserGroupId(invitation.getGroup(),invitation.getUser()));
        if ( userGroupHost == null || userGroupNewUser != null || !userGroupHost.getUserType().getName().equals( "ADMIN") ) {
            return null;
        }
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
