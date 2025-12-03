package ru.KGU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.KGU.domain.User;
import ru.KGU.domain.UserGroup;

import java.util.List;

public interface UserRepository  extends JpaRepository<User,Integer> {
    User findById(String id);
    void deleteById(String id);
}
