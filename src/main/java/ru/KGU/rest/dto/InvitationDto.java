package ru.KGU.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

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
