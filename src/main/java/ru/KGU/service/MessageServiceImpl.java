package ru.KGU.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.KGU.domain.Group;
import ru.KGU.domain.Message;
import ru.KGU.repository.MessageRepository;

import java.util.Comparator;
import java.util.List;
@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    @Override
    public Message getMessage(int id) {
        return messageRepository.findById(id);
    }

    @Override
    public Message updateMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessageByGroupSortedByDate(Group group) {
        List<Message> messages = messageRepository.findByGroup(group);
        messages.sort(Comparator.comparing(Message::getDate));
        return messages;
    }

    @Override
    public void deleteMessage(int id) {
        messageRepository.deleteById(id);
    }
}
