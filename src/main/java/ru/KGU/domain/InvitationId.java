package ru.KGU.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvitationId implements Serializable {
    private User host;
    private Group group;
    private User user;
}
