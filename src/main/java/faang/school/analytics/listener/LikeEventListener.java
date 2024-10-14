package faang.school.analytics.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import faang.school.analytics.mapper.analyticevent.AnalyticsEventMapper;
import faang.school.analytics.model.dto.LikeEventDto;
import faang.school.analytics.model.entity.AnalyticsEvent;
import faang.school.analytics.model.enums.EventType;
import faang.school.analytics.service.AnalyticsEventService;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class LikeEventListener extends AbstractEventListener<LikeEventDto> implements MessageListener {

    public LikeEventListener(AnalyticsEventService analyticsEventService,
                             AnalyticsEventMapper analyticsEventMapper,
                             ObjectMapper objectMapper) {
        super(analyticsEventService, analyticsEventMapper, objectMapper);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        LikeEventDto dto = handleEvent(message, LikeEventDto.class);
        AnalyticsEvent entity = analyticsEventMapper.toEntity(dto);
        entity.setEventType(EventType.POST_LIKE);
        analyticsEventService.saveEvent(entity);
    }
}