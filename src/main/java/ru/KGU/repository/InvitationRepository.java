package ru.KGU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.KGU.domain.Group;
import ru.KGU.domain.Invitation;
import ru.KGU.domain.User;

import java.util.List;

public interface InvitationRepository  extends JpaRepository<Invitation, Integer> {
    void deleteByHostAndUserAndGroup(User host, User newUser, Group group);
    Invitation findByHostAndUserAndGroup(User host, User newUser, Group group);
    List<Invitation> findByHost(User host);
    List<Invitation> findByUser(User newUser);
    List<Invitation> findByGroup(Group group);
}
