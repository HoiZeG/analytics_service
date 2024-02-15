package faang.school.analytics.mapper;

import faang.school.analytics.dto.MentorshipRequestedEvent;
import faang.school.analytics.model.AnalyticsEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MentorshipRequestedMapperTest {
    private final MentorshipRequestedMapper mentorshipRequestedMapper = new MentorshipRequestedMapperImpl();
    private final MentorshipRequestedEvent event = new MentorshipRequestedEvent(1L, 2L, LocalDateTime.now());

    @Test
    void toAnalyticsEvent() {
        AnalyticsEvent analyticsEvent = mentorshipRequestedMapper.toAnalyticsEvent(event);
        assertEquals(event.getRequesterId(), analyticsEvent.getActorId());
        assertEquals(event.getReceiverId(), analyticsEvent.getReceiverId());
        assertEquals(event.getTimestamp(), analyticsEvent.getReceivedAt());
        assertEquals(faang.school.analytics.model.EventType.MENTORSHIP_REQUESTED, analyticsEvent.getEventType());
    }
}