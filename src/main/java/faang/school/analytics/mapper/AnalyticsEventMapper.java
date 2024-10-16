package faang.school.analytics.mapper;

import faang.school.analytics.dto.AbstractEventDto;
import faang.school.analytics.dto.AnalyticsEventDto;
import faang.school.analytics.model.AnalyticsEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnalyticsEventMapper {

    @Mapping(source = "timestamp", target = "receivedAt")
    AnalyticsEvent toAnalyticsEvent(AbstractEventDto abstractEventDto);
    AnalyticsEvent toAnalyticsEventFromAbstractEvent(AbstractEventDto abstractEventDto);

    AnalyticsEvent toAnalyticsEvent(AbstractEventDto abstractEventDto);

    AnalyticsEventDto toAnalyticsEventDto(AnalyticsEvent analyticsEvent);
}
