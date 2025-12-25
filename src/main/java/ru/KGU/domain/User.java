package ru.KGU.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "app_user")
public class User {
    @Id
    private String id;
    private String name;
    private String password;

    @Column(name = "public_key_for_invitation")
    private String publicKeyForInvitation;

    @Column(name = "recovery_password")
    private String recoveryPassword;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserGroup> groups;
}
