package com.web.service;

import com.github.pagehelper.PageInfo;
import com.web.common.ServerResponse;
import com.web.pojo.Event;

import java.util.Date;
import java.util.List;

public interface IEventService {
    ServerResponse<List<Event>> upcomingEvents(Date time);

    ServerResponse saveOrUpdateEvent(Event event);

    ServerResponse<PageInfo> getEventList(int pageNum, int pageSize);

    ServerResponse<PageInfo> getEventsByKeywordCategory(String eventName, Integer categoryId, int pageNum, int pageSize);

}
