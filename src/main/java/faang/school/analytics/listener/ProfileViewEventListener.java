package faang.school.analytics.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import faang.school.analytics.mapper.analyticevent.AnalyticsEventMapper;
import faang.school.analytics.model.entity.AnalyticsEvent;
import faang.school.analytics.model.enums.EventType;
import faang.school.analytics.model.event.ProfileViewEvent;
import faang.school.analytics.service.AnalyticsEventService;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class ProfileViewEventListener extends AbstractEventListener<ProfileViewEvent> implements MessageListener {
    public ProfileViewEventListener(AnalyticsEventService analyticsEventService, AnalyticsEventMapper analyticsEventMapper, ObjectMapper objectMapper) {
        super(analyticsEventService, analyticsEventMapper, objectMapper);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        ProfileViewEvent profileViewEvent = handleEvent(message, ProfileViewEvent.class);
        AnalyticsEvent analyticsEvent = analyticsEventMapper.toEntity(profileViewEvent);
        analyticsEvent.setEventType(EventType.PROFILE_VIEW);
        analyticsEventService.saveEvent(analyticsEvent);
    }
}