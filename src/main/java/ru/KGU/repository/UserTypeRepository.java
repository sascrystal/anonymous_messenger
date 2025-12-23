package ru.KGU.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.KGU.domain.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
    UserType findByName(String name);
    void deleteByName(String name);
}
