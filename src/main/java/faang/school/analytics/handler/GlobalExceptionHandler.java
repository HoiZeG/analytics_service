package faang.school.analytics.handler;

import faang.school.analytics.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({ConversionFailedException.class, ValidationException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage handleValidation(RuntimeException e) {

        log.error("Caught exception from validation group", e);
        return ErrorMessage.builder()
                .timestamp(LocalDateTime.now())
                .message(e.getMessage())
                .causeMessage(e.getCause().getMessage())
                .build();
    }
}