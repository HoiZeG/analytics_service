package faang.school.analytics.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class Mapper {
    private ObjectMapper objectMapper;

    public <T> Optional<T> toObject(String json, Class<T> valueType) {
        T object = null;
        try {
            object = objectMapper.readValue(json, valueType);
        } catch (IOException e) {
            log.error("Exception with json mapping: " + e.getMessage());
        }
        return Optional.ofNullable(object);
    }
}
