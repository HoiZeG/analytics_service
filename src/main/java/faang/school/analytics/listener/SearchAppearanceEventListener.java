package faang.school.analytics.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import faang.school.analytics.mapper.AnalyticsEventMapper;
import faang.school.analytics.model.AnalyticsEventService;
import faang.school.analytics.model.dto.SearchAppearanceEvent;
import faang.school.analytics.model.entity.AnalyticsEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class SearchAppearanceEventListener implements MessageListener {
    private final ObjectMapper objectMapper;
    private final AnalyticsEventService analyticsEventService;
    private final AnalyticsEventMapper mapper;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            SearchAppearanceEvent event = objectMapper.readValue(message.getBody(), SearchAppearanceEvent.class);
            AnalyticsEvent analyticsEvent = mapper.fromSearchAppearanceToEntity(event);
            analyticsEventService.saveEvent(analyticsEvent);
        } catch (IOException e) {
            log.error("Failed to convert message", e);
            throw new RuntimeException(e);
        }
    }
}