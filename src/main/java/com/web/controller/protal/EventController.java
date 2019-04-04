package com.web.controller.protal;

import com.google.gson.Gson;
import com.web.pojo.Event;
import com.web.service.IEventService;
import com.web.service.impl.CategoryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/event/")
@Slf4j
public class EventController {

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private IEventService iEventService;

    @RequestMapping("upcomingEvent.do")
    @ResponseBody
    public String upcomingEvent(@RequestParam("callback") String callback) {
        Gson gson=new Gson();
        logger.info(callback);
        return callback+ "(" + gson.toJson(iEventService.upcomingEvents(new Date())) + ")" ;
    }

    @RequestMapping("save.do")
    @ResponseBody
    public String productSave(Event event, @RequestParam("callback") String callback) {
        Gson gson=new Gson();
        logger.info(callback);
        return callback+ "(" + gson.toJson(iEventService.saveOrUpdateEvent(event)) + ")" ;
    }

    @RequestMapping("list.do")
    @ResponseBody
    public String getList(@RequestParam("callback") String callback) {
        Gson gson=new Gson();
        logger.info(callback);
        return callback+ "(" + gson.toJson(iEventService.getEventList()) + ")" ;
    }

    @RequestMapping("CategoryList.do")
    @ResponseBody
    public String getListByCategoryId(String eventName, Integer categoryId, @RequestParam("callback") String callback) {
        Gson gson=new Gson();
        logger.info(callback);
        return callback+ "(" + gson.toJson(iEventService.getEventsByKeywordCategory(eventName, categoryId)) + ")" ;
    }

    @RequestMapping(value = "save.do", method = RequestMethod.POST)
    @ResponseBody
    public String eventSave(Event event, @RequestParam("finalTime") String finalTime ,@RequestParam("callback") String callback) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(finalTime);
        event.setTime(date);
        Gson gson=new Gson();
        logger.info(callback);
        return callback+ "(" + gson.toJson(iEventService.saveOrUpdateEvent(event)) + ")" ;
    }

}
