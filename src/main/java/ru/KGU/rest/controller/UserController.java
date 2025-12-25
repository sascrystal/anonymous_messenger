package ru.KGU.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.KGU.domain.Group;
import ru.KGU.domain.User;
import ru.KGU.rest.dto.GroupDto;
import ru.KGU.rest.dto.UserDto;
import ru.KGU.rest.mapper.UserDtoMapper;
import ru.KGU.service.GroupService;
import ru.KGU.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final GroupService groupService;
    private final UserDtoMapper userDtoMapper;
    @PostMapping("/registration")
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = userDtoMapper.toDomainObject(userDto);
        if(userService.getUser(user.getId()) == null) {
            return userDtoMapper.toDto(userService.createUser(user));
        }
        return null;
    }
    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable String id) {
        return userDtoMapper.toDto(userService.getUser(id));
    }



}
