package ru.KGU.rest.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.KGU.domain.Message;
import ru.KGU.rest.dto.MessageDto;
import ru.KGU.service.GroupService;
import ru.KGU.service.UserService;


@RequiredArgsConstructor
@Component
public class MessageDtoMapper {
    private final GroupService groupService;
    private final UserService userService;

    public MessageDto toDto(Message message) {
        return MessageDto.builder()
                .id(message.getId())
                .date(message.getDate())
                .content(message.getContent())
                .authorId(message.getAuthor().getId())
                .groupId(message.getId()).build();
    }

    public Message toDomainObject(MessageDto messageDto) {
        return Message.builder()
                .id(messageDto.getId())
                .date(messageDto.getDate())
                .group(groupService.getGroup(messageDto.getId()))
                .author(userService.getUser(messageDto.getAuthorId())).build();
    }

}
