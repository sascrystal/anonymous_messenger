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
@IdClass(InvitationId.class)
public class Invitation {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id", nullable = false, foreignKey = @ForeignKey(name = "fk_invitation_host_id"))
    private User host;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "new_user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_invitation_new_user_id"))
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false, foreignKey = @ForeignKey(name = "fk_invitation_group_id"))
    private Group group;


    @Column(name = "public_key_for_group")
    private String publicKeyForGroup;

    @Column(name = "private_key_for_group")
    private String privateKeyForGroup;


}
