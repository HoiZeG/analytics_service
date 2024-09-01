package faang.school.analytics.mapper.recommendation;

import faang.school.analytics.model.AnalyticsEvent;
import faang.school.analytics.dto.event.recommendation.RecommendationEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RecommendationEventMapper {
    @Mapping(source = "recommendationId", target = "id")
    @Mapping(source = "authorId", target = "actorId")
    @Mapping(source = "receiverId", target = "receiverId")
    @Mapping(source = "timestamp", target = "receivedAt")
    AnalyticsEvent toEntity(RecommendationEvent recommendationEvent);
}