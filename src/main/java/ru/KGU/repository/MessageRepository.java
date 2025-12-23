package ru.KGU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.KGU.domain.Group;
import ru.KGU.domain.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    Message findById(int id);
    List<Message> findByGroup(Group group);
    void deleteById(int id);

}
