package ru.KGU.service;

import ru.KGU.domain.Group;
import ru.KGU.domain.Message;

import java.util.List;

public interface MessageService {
    Message getMessage(int id);
    Message updateMessage(Message message);
    Message createMessage(Message message);
    List<Message> getMessageByGroupSortedByDate(Group group);
    void deleteMessage(int id);
}
