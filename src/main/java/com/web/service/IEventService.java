package com.web.service;

import com.web.common.ServerResponse;
import com.web.pojo.Event;

import java.util.Date;
import java.util.List;

public interface IEventService {
    ServerResponse<List<Event>> upcomingEvents(Date time);

    ServerResponse saveOrUpdateEvent(Event event);

    ServerResponse<List<Event>> getEventList();

    ServerResponse<List<Event>> getEventsByKeywordCategory(String eventName, Integer categoryId);

}
