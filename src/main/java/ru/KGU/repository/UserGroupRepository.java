package ru.KGU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.KGU.domain.Group;
import ru.KGU.domain.User;
import ru.KGU.domain.UserGroup;
import ru.KGU.domain.UserType;

import java.util.List;

public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {
    void deleteByUserAndGroup(User user, Group group);

    UserGroup findByUserAndGroup(User user, Group group);

    List<UserGroup> findByUser(User user);

    List<UserGroup> findByGroup(Group group);

    List<UserGroup> findByGroupAndUserType(Group group, UserType userType);
}
