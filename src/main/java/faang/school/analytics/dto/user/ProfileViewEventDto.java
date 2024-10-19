package faang.school.analytics.dto.user;

import faang.school.analytics.model.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProfileViewEventDto {
    private long receiverId;
    private long actorId;
    private final EventType eventType = EventType.PROFILE_VIEW;
    private LocalDateTime receivedAt;
}