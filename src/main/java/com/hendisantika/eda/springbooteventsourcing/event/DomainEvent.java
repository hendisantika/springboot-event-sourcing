package com.hendisantika.eda.springbooteventsourcing.event;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-event-sourcing
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-24
 * Time: 06:58
 */
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.CLASS)
public abstract class DomainEvent implements Serializable {
    private long eventId;
    private Long aggregateId;
    private Date timestamp;

    public DomainEvent() {
    }

    public DomainEvent(long eventId, Long aggregateId) {
        this.eventId = eventId;
        this.timestamp = new Date();
        setAggregateId(aggregateId);
    }

    public Long getAggregateId() {
        return aggregateId;
    }

    private void setAggregateId(Long aggregateId) {
        this.aggregateId = aggregateId;
    }

    public long getEventId() {
        return eventId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

}