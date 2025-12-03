package ru.KGU.service;

import ru.KGU.domain.Group;
import ru.KGU.domain.User;

import java.util.List;

public interface GroupService {
    Group createGroup(Group group);
    Group getGroup(int id);
    Group updateGroup(Group group);
    List<Group> getAllGroupsByUser(User user);
    void deleteGroup(int id);

}
