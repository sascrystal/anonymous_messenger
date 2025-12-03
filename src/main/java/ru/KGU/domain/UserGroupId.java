package ru.KGU.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
@AllArgsConstructor
public class UserGroupId {
    private Group group;
    private User user;
}
