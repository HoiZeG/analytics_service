package faang.school.analytics.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostViewEvent {
    private Long postId;
    private Long userAuthorId;
    private Long projectAuthorId;
    private Long viewerId;
    private LocalDateTime time = LocalDateTime.now();

    public PostViewEvent(Long postId, Long userAuthorId, Long projectAuthorId, Long viewerId) {
        this.postId = postId;
        this.userAuthorId = userAuthorId;
        this.projectAuthorId = projectAuthorId;
        this.viewerId = viewerId;
    }
}