package faang.school.analytics.service;

import faang.school.analytics.model.AnalyticsEvent;
import faang.school.analytics.repository.AnalyticsEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
//Удалить класс и папку
@Service
@RequiredArgsConstructor
public class AnalyticsEventService {
    private final AnalyticsEventRepository analyticsEventRepository;

    public void save(AnalyticsEvent analyticsEvent){
        analyticsEventRepository.save(analyticsEvent);
    }

}
