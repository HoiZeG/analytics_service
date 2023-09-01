package faang.school.analytics.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import faang.school.analytics.exception.DeserializeJSONException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;

import java.io.IOException;

@RequiredArgsConstructor
public class AbstractEventListener<T> {

    private final ObjectMapper objectMapper;

    protected T convertJsonToString(Message message, Class<T> type) {
        T event;
        try {
            event = objectMapper.readValue(message.getBody(), type);
        } catch (IOException e) {
            throw new DeserializeJSONException("Could not deserialize event");
        }
        return event;
    }
}
