package ru.KGU.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.KGU.domain.Group;
import ru.KGU.domain.User;

@AllArgsConstructor
@Data
@Builder
public class InvitationDto {
    private String hostId;
    private String newUserId;
    private int groupId;
    private String publicKey;
    private String privateKey;
}
