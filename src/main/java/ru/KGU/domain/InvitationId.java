package ru.KGU.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@EqualsAndHashCode
@Data
@AllArgsConstructor
public class InvitationId implements Serializable {
    private User host;
    private Group group;
    private User user;
}
