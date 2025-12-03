package ru.KGU.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_group")
public class UserGroup {

    @Id
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false, foreignKey = @ForeignKey(name = "fk_users_groups_group_id"))
    private Group group;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_users_groups_user_id"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "type_user", nullable = false, foreignKey = @ForeignKey(name = "fk_users_groups_user_type"))
    private UserType userType;
}
