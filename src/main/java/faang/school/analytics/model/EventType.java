package faang.school.analytics.model;

import faang.school.analytics.dto.event.type.service.post.like.PostLikeEventDto;

public enum EventType {
    PROFILE_VIEW,
    PROJECT_VIEW,
    FOLLOWER,
    POST_PUBLISHED,
    POST_VIEW,
    POST_LIKE,
    POST_COMMENT,
    SKILL_RECEIVED,
    RECOMMENDATION_RECEIVED,
    ADDED_TO_FAVOURITES,
    PROJECT_INVITE,
    TASK_COMPLETED,
    GOAL_COMPLETED,
    ACHIEVEMENT_RECEIVED,
    PROFILE_APPEARED_IN_SEARCH,
    PROJECT_APPEARED_IN_SEARCH;
}
