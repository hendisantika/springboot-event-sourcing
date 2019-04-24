package com.hendisantika.eda.springbooteventsourcing.event;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-event-sourcing
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-24
 * Time: 07:00
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class UserDeactivatedEvent extends DomainEvent {
    private Long userId;

    private String adminName;

    public UserDeactivatedEvent() {
        super();
    }

    public UserDeactivatedEvent(long eventId, Long userId, String adminName) {
        super(eventId, userId);
        this.userId = userId;
        this.adminName = adminName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        return "UserDeactivatedEvent{" +
                "userId=" + userId +
                ", adminName='" + adminName + '\'' +
                ", eventId='" + getEventId() + '\'' +
                '}';
    }
}