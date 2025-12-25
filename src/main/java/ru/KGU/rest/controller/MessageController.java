package ru.KGU.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.KGU.domain.Message;
import ru.KGU.domain.UserGroup;
import ru.KGU.domain.UserGroupId;
import ru.KGU.rest.dto.MessageDto;
import ru.KGU.rest.mapper.MessageDtoMapper;
import ru.KGU.service.GroupService;
import ru.KGU.service.MessageService;
import ru.KGU.service.UserGroupService;
import ru.KGU.service.UserService;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private final MessageDtoMapper messageDtoMapper;
    private final UserGroupService userGroupService;
    private final UserService userService;
    private final GroupService groupService;

    @PostMapping("/user/{id}/message")
    public MessageDto sentMessage(@PathVariable String id, @RequestBody MessageDto messageDto) {
        Message message = messageDtoMapper.toDomainObject(messageDto);
        if (!Objects.equals(messageDto.getAuthorId(), id)) {
            return null;
        }
        return messageDtoMapper.toDto(messageService.createMessage(message));
    }

    @GetMapping("/user/{id}/message/{groupId}")
    public List<MessageDto> getMessages(@PathVariable String id, @PathVariable int groupId) {
        UserGroup userGroup = userGroupService.getUserGroup(new UserGroupId(groupService.getGroup(groupId), userService.getUser(id)));
        if (userGroup == null) {
            return null;
        }
        return messageService.getMessageByGroupSortedByDate(groupService.getGroup(groupId)).stream().map(messageDtoMapper::toDto).toList();
    }
}
