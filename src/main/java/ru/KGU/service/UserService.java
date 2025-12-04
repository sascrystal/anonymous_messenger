package ru.KGU.service;

import ru.KGU.domain.Group;
import ru.KGU.domain.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUser(String id);
    User updateUser(User user);
    List<User> getUsersByGroup(Group group);
    void deleteUser(String id);
    Boolean isUserExist(String id);
    Boolean passwordIsCorrect(String id, String password);

}
