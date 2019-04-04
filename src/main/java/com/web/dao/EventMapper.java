package com.web.dao;

import com.web.pojo.Event;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EventMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Event event);

    int insertSelective(Event event);

    Event selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Event event);

    int updateByPrimaryKey(Event event);

    List<Event> upcomingEvents(@Param(value = "time") Date time);

    List<Event> selectList();

    List<Event> selectByNameAndEventId(@Param(value = "eventName") String eventName, @Param(value = "eventId") Integer eventId);

    List<Event> selectByNameAndCategoryId(@Param(value = "eventName") String eventName, @Param("categoryId") Integer categoryId);
}
