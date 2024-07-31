package faang.school.analytics.dto.event;

import faang.school.analytics.model.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnalyticsEventDto {
    private long id;
    private long receiverId;
    private long actorId;
    private Long postId;
    private Long commentId;
    private EventType eventType;
    private LocalDateTime receivedAt;
}