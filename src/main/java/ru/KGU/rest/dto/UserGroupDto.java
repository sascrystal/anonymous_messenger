package ru.KGU.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.KGU.domain.Group;
import ru.KGU.domain.User;
import ru.KGU.domain.UserGroup;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserGroupDto {
    private int groupId;
    private String userId;
    private UserTypeDto userTypeDto;



}
