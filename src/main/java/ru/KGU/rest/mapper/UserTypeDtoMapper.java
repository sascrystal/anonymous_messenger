package ru.KGU.rest.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.KGU.domain.UserType;
import ru.KGU.repository.UserTypeRepository;
import ru.KGU.rest.dto.UserTypeDto;

@RequiredArgsConstructor
@Component
public class UserTypeDtoMapper {
    private final UserTypeRepository userTypeRepository;  // ← ДОБАВЬ

    public UserTypeDto toDto(UserType userType) {
        return new UserTypeDto(userType.getName());
    }

    public UserType toDomainObject(UserTypeDto userTypeDto) {
        // Ищем существующий UserType
        return userTypeRepository.findByName(userTypeDto.getName());

    }
}