package faang.school.analytics.config.context;

import faang.school.analytics.listener.FollowerEventListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.util.Pair;

@Configuration
public class FollowerEventConfig {

    @Value("${spring.data.redis.channel.follower}")
    private String followerChannelName;

    @Bean
    public ChannelTopic followerTopic() {
        return new ChannelTopic(followerChannelName);
    }


    @Bean
    public MessageListenerAdapter followerMessageListener(FollowerEventListener followerEventListener) {
        return new MessageListenerAdapter(followerEventListener);
    }

    @Bean
    Pair<MessageListenerAdapter, ChannelTopic> followerRequester(MessageListenerAdapter followerMessageListener) {
        return Pair.of(followerMessageListener, followerTopic());
    }
}