package faang.school.analytics.redis;

import faang.school.analytics.service.AnalyticsEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LikeEventListener implements MessageListener {
    public static List<String> messageList = new ArrayList<String>();
    private final AnalyticsEventService analyticsEventService;

    @Autowired
    public LikeEventListener(AnalyticsEventService analyticsEventService) {
        this.analyticsEventService = analyticsEventService;
    }

    public void onMessage(Message message, byte[] pattern) {
        messageList.add(message.toString());
        System.out.println("Message received: " + message.toString());
        analyticsEventService.saveLikeEvent(message);
    }
}