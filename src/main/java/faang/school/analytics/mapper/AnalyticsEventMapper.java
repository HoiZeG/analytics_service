package faang.school.analytics.mapper;

import faang.school.analytics.event.GoalCompletedEvent;
import faang.school.analytics.model.AnalyticsEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnalyticsEventMapper {

    @Mapping(source = "userId", target = "actorId")
    @Mapping(source = "completedAt", target = "receivedAt")
    @Mapping(source = "goalId", target = "receiverId")
    @Mapping(target = "eventType", defaultValue = "EventType.GOAL_COMPLETED")
    AnalyticsEvent toAnalyticsEvent(GoalCompletedEvent goalCompletedEvent);
}
