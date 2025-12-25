package ru.KGU.rest.dto;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.KGU.domain.Group;
import ru.KGU.domain.User;

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
