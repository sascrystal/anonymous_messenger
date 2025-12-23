package ru.KGU.rest.mapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.KGU.domain.UserType;
import ru.KGU.rest.dto.UserTypeDto;

@RequiredArgsConstructor
@Component
public class UserTypeDtoMapper {
    public  UserTypeDto toDto(UserType userType) {
        return new UserTypeDto(userType.getName());
    }

    public  UserType toDomainObject(UserTypeDto userTypeDto){
        return UserType.builder().name(userTypeDto.getName()).build();
    }
}
