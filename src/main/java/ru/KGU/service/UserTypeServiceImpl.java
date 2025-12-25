package ru.KGU.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.KGU.domain.UserType;
import ru.KGU.repository.UserTypeRepository;

@Service
@AllArgsConstructor
public class UserTypeServiceImpl implements UserTypeService {
    private final UserTypeRepository userTypeRepository;

    @Override
    public UserType getUserType(String name) {
        return userTypeRepository.findByName(name);
    }
}
