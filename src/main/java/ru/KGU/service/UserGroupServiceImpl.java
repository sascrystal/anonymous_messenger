package ru.KGU.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.KGU.domain.Group;
import ru.KGU.domain.UserGroup;
import ru.KGU.domain.UserGroupId;
import ru.KGU.domain.UserType;
import ru.KGU.repository.UserGroupRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserGroupServiceImpl implements UserGroupService {
    private final UserGroupRepository userGroupRepository;

    @Override
    public UserGroup getUserGroup(UserGroupId id) {
        return userGroupRepository.findByUserAndGroup(id.getUser(), id.getGroup());
    }

    @Override
    public UserGroup createUserGroup(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    @Override
    public UserGroup updateUserGroup(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    @Override
    public void deleteUserGroup(UserGroupId userGroupId) {
        userGroupRepository.deleteByUserAndGroup(userGroupId.getUser(), userGroupId.getGroup());

    }

    @Override
    public List<UserGroup> getUserGroupsByGroupAndUserType(Group group, UserType userType) {
        return userGroupRepository.findByGroupAndUserType(group, userType);
    }
}
