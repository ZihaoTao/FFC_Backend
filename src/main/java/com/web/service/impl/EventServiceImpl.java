package com.web.service.impl;

import com.web.common.ResponseCode;
import com.web.common.ServerResponse;
import com.web.dao.EventMapper;
import com.web.pojo.Event;
import com.web.service.IEventService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("iEventService")
@Slf4j
public class EventServiceImpl implements IEventService {

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private EventMapper eventMapper;

    @Override
    public ServerResponse<List<Event>> upcomingEvents(Date time) {
        List<Event> list = eventMapper.upcomingEvents(time);
        if(CollectionUtils.isEmpty(list)) {
            logger.info("Cannot find children of this category");
        }
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse saveOrUpdateEvent(Event event) {
        if (event != null) {
            if(StringUtils.isNotBlank(event.getSubImages())) {
                String[] subImageArray = event.getSubImages().split(",");
                if(subImageArray.length > 0) event.setMainImage(subImageArray[0]);
                if(event.getId() != null) {
                    int rowCount = eventMapper.updateByPrimaryKey(event);
                    if (rowCount > 0) {
                        return ServerResponse.createBySuccess("Event updated successfully");
                    } else {
                        return ServerResponse.createByErrorMessage("Cannot updated event");
                    }
                }
            } else {
                int rowCount = eventMapper.insert(event);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccess("Event added successfully");
                } else {
                    return ServerResponse.createByErrorMessage("Cannot add event");
                }
            }
        }
        return ServerResponse.createByErrorMessage("Incorrect index for adding or updating event");
    }

    @Override
    public ServerResponse<List<Event>> getEventList() {
        List<Event> list = eventMapper.selectList();
        return ServerResponse.createBySuccess(list);
    }

    @Override
    public ServerResponse<List<Event>> getEventsByKeywordCategory(String eventName, Integer categoryId) {
        if(StringUtils.isBlank(eventName) && categoryId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        return ServerResponse.createBySuccess(eventMapper.selectByNameAndCategoryId(eventName, categoryId));
    }
}
