package ru.KGU.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.util.List;
@AllArgsConstructor
@Data
@Builder
public class GroupDto {
    private int id;
    private String name;
    private String description;
    private List<UserGroupDto> userGroupsDto;



}
