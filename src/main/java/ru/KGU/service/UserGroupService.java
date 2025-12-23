package ru.KGU.service;

import ru.KGU.domain.Group;
import ru.KGU.domain.UserGroup;
import ru.KGU.domain.UserGroupId;
import ru.KGU.domain.UserType;

import java.util.List;

public interface UserGroupService {
    UserGroup getUserGroup(UserGroupId id);
    UserGroup createUserGroup(UserGroup userGroup);
    UserGroup updateUserGroup(UserGroup userGroup);
    void deleteUserGroup(UserGroupId userGroupId);
    List<UserGroup> getUserGroupsByGroupAndUserType(Group group, UserType userType);


}
