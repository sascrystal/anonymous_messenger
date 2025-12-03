package ru.KGU.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.KGU.domain.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    void deleteById(int id);
    Group findById(int id);

}
