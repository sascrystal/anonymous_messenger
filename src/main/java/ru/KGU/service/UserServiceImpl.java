package ru.KGU.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.KGU.domain.Group;
import ru.KGU.domain.User;
import ru.KGU.domain.UserGroup;
import ru.KGU.repository.UserGroupRepository;
import ru.KGU.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserGroupRepository userGroupRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsersByGroup(Group group) {
        return userGroupRepository.findByGroup(group).stream()
                .map(UserGroup::getUser)
                .toList();
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
