package com.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
            if(event.getId() != null) {
                int rowCount = eventMapper.updateByPrimaryKey(event);
                if (rowCount > 0) {
                    return ServerResponse.createBySuccess("Event updated successfully");
                } else {
                    return ServerResponse.createByErrorMessage("Cannot updated event");
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
    public ServerResponse<PageInfo> getEventList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Event> list = eventMapper.selectList();
        PageInfo pageResult = new PageInfo(list);
        return ServerResponse.createBySuccess(pageResult);
    }

    @Override
    public ServerResponse<PageInfo> getEventsByKeywordCategory(String eventName, Integer categoryId, int pageNum, int pageSize) {
        if(StringUtils.isBlank(eventName) && categoryId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        if(categoryId != null && StringUtils.isBlank(eventName)) {
            // this is not an error, should return a blank list
            PageHelper.startPage(pageNum, pageSize);
            List<Event> list = eventMapper.selectList();
            PageInfo pageResult = new PageInfo(list);
            return ServerResponse.createBySuccess(pageResult);
        }
        if(StringUtils.isNotBlank(eventName)) {
            eventName = '%' + eventName + '%';
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Event> list = eventMapper.selectByNameAndCategoryId(StringUtils.isBlank(eventName) ? null:eventName, categoryId);
        PageInfo pageInfo = new PageInfo(list);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
