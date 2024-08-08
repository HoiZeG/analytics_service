package faang.school.analytics.mapper;

import faang.school.analytics.dto.mentorship.MentorshipRequestEvent;
import faang.school.analytics.model.AnalyticsEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AnalyticsEventMapper {
    @Mapping(source = "requesterId", target = "actorId")
    @Mapping(source = "receiverId", target = "receiverId")
    @Mapping(source = "receivedAt", target = "receivedAt")
    AnalyticsEvent toEntity(MentorshipRequestEvent mentorshipRequestEvent);
}
