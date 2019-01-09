package com.web.controller.protal;

import com.web.common.Const;
import com.web.common.ServerResponse;
import com.web.util.CookieUtil;
import com.web.util.JsonUtil;
import com.web.util.RedisShardedPoolUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by tino
 */

@Controller
@RequestMapping("/display/")
public class DisplayController {



    @RequestMapping(value = "setCookie.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse setCookie(HttpSession session, HttpServletResponse httpServletResponse){
        ServerResponse response = ServerResponse.createBySuccess("Check first time visit");
        CookieUtil.writeCheckToken(httpServletResponse, session.getId());
        RedisShardedPoolUtil.setEx(session.getId(), JsonUtil.obj2String(response.getData()), Const.RedisCacheEx.REDIS_SESSION_EXTIME);
        return response;
    }

    @RequestMapping(value = "popup.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse popup(HttpServletRequest httpServletRequest){
        String checkToken =CookieUtil.readCheckToken(httpServletRequest);
        if(StringUtils.isEmpty(checkToken)) {
            return ServerResponse.createByErrorMessage("This is the first time to visit");
        }
        return ServerResponse.createBySuccess("This is not the first time to visit");
    }
}
