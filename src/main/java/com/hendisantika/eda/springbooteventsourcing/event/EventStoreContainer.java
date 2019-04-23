package com.hendisantika.eda.springbooteventsourcing.event;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-event-sourcing
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-24
 * Time: 06:59
 */

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.CLASS)
public class EventStoreContainer implements Serializable {
    public DomainEvent event;

    private EventStoreContainer() {
    }

    public EventStoreContainer(DomainEvent event) {
        this.event = event;
    }

    public DomainEvent getEvent() {
        return event;
    }

    public void setEvent(DomainEvent event) {
        this.event = event;
    }
}