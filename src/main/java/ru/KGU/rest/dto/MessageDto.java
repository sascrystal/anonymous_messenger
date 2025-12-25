package ru.KGU.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class MessageDto {
    private int id;

    private String content;

    private LocalDateTime date;

    private String authorId;

    private int groupId;
}
