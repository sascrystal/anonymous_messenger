package ru.KGU.rest.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.provisioning.GroupManager;
import org.springframework.web.bind.annotation.*;
import ru.KGU.domain.Group;
import ru.KGU.domain.User;
import ru.KGU.rest.dto.GroupDto;
import ru.KGU.rest.mapper.GroupDtoMapper;
import ru.KGU.service.GroupService;
import ru.KGU.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final GroupDtoMapper groupDtoMapper;
    private final UserService userService;

    @PostMapping("/user/{id}/group")
    public GroupDto createGroup(@PathVariable String id, @RequestBody GroupDto groupDto) {
        Group group =   groupDtoMapper.toDomainObject(groupDto);
        return groupDtoMapper.toDto(groupService.createGroup(group,userService.getUser(id)));
    }
    @GetMapping("/user/{id}/group")
    public List<GroupDto> getGroup(@PathVariable String id) {
        User user = userService.getUser(id);
        return groupService.getAllGroupsByUser(user).stream().map(groupDtoMapper::toDto).toList();


    }
}
