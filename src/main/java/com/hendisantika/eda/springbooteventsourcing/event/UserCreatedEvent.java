package com.hendisantika.eda.springbooteventsourcing.event;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hendisantika.eda.springbooteventsourcing.domain.User;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-event-sourcing
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-24
 * Time: 06:59
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class UserCreatedEvent extends DomainEvent {
    private User user;

    public UserCreatedEvent() {
        super();
    }

    public UserCreatedEvent(long eventId, User user) {
        super(eventId, user.getId());
        this.user = user;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserCreatedEvent{" +
                "aggregateId=" + getAggregateId() +
                "eventId=" + getEventId() +
                "timestamp=" + getTimestamp() +
                "user=" + user +
                '}';
    }
}