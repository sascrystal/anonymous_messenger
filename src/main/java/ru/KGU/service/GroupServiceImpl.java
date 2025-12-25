package ru.KGU.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.KGU.domain.Group;
import ru.KGU.domain.User;
import ru.KGU.domain.UserGroup;
import ru.KGU.domain.UserType;
import ru.KGU.repository.GroupRepository;
import ru.KGU.repository.UserGroupRepository;
import ru.KGU.repository.UserTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final UserGroupRepository userGroupRepository;
    private final UserGroupService userGroupService;
    private final UserTypeRepository userTypeRepository;

    @Override
    public Group createGroup(Group group, User host) {
        if (host == null) {
            return null;
        }
        UserType userType = userTypeRepository.findByName("ADMIN");
        List<UserGroup> userGroups = new ArrayList<>();
        UserGroup userGroup = UserGroup.builder().userType(userType).user(host).group(group).build();
        userGroups.add(userGroup);
        group.setUsers(userGroups);
        return groupRepository.save(group);
    }

    @Override
    public Group getGroup(int id) {
        return groupRepository.findById(id);
    }

    @Override
    public Group updateGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public List<Group> getAllGroupsByUser(User user) {
        return userGroupRepository.findByUser(user).stream()
                .map(UserGroup::getGroup)
                .toList();
    }

    @Override
    public void deleteGroup(int id) {
        groupRepository.deleteById(id);
    }
}
