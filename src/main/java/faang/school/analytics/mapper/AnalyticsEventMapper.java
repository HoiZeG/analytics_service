package faang.school.analytics.mapper;

import faang.school.analytics.dto.CommentEventDto;
import faang.school.analytics.model.AnalyticsEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnalyticsEventMapper {

    @Mapping(target = "actorId", source = "authorId")
    @Mapping(target = "eventType", ignore = true)
    @Mapping(target = "receivedAt", source = "createdAt")
    @Mapping(target = "receiverId", source = "postId")
    AnalyticsEvent toCommentEntity(CommentEventDto commentEventDto);
}