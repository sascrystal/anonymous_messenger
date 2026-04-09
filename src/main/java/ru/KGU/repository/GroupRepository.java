package ru.KGU.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.KGU.domain.Group;
@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

    void deleteById(int id);

    Group findById(int id);

}
