package faang.school.analytics.config;

import faang.school.analytics.listener.FollowerEventListener;
import faang.school.analytics.listener.LikePostMessageListener;
import faang.school.analytics.listener.MentorshipMessageListener;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
@RequiredArgsConstructor
public class RedisConfig {

    private final LikePostMessageListener likePostMessageListener;
    private final FollowerEventListener followerEventListener;
    private final MentorshipMessageListener mentorshipMessageListener;

    @Value("${spring.data.redis.host}")
    private String host;
    @Value("${spring.data.redis.port}")
    private int port;
    @Value("${spring.data.redis.channels.event_channels.likePost}")
    private String likeTopicName;
    @Value("${spring.data.redis.channels.follower_channel.name}")
    private String followerTopicName;
    @Value("${spring.data.redis.channels.event_channels.mentorship}")
    private String mentorshipName;

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(host, port);
        return new JedisConnectionFactory(config);
    }

    @Bean
    public RedisMessageListenerContainer redisContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory());

        MessageListenerAdapter followerEventMessageListenerAdapter = new MessageListenerAdapter(followerEventListener);
        MessageListenerAdapter likePostMessageListenerAdapter = new MessageListenerAdapter(likePostMessageListener);

        container.addMessageListener(likePostMessageListenerAdapter, new ChannelTopic(likeTopicName));
        container.addMessageListener(followerEventMessageListenerAdapter, new ChannelTopic(followerTopicName));
        container.addMessageListener(likePostMessageListenerAdapter, new ChannelTopic(mentorshipName));

        return container;
    }
}