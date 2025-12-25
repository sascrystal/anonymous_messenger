package ru.KGU.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserGroupDto {
    private int groupId;
    private String userId;
    private UserTypeDto userTypeDto;


}
