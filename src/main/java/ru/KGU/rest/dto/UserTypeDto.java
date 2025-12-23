package ru.KGU.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.KGU.domain.UserType;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserTypeDto {
    private String name;

}
