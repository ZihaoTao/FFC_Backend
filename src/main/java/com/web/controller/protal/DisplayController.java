package com.web.controller.protal;

import com.web.common.Const;
import com.web.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by tino
 */

@Controller
@RequestMapping("/springsession/")
public class DisplayController {



    @RequestMapping(value = "setCookie.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse setCookie(HttpSession session){
        ServerResponse response = ServerResponse.createBySuccess("Check first time visit");
        session.setAttribute(Const.NOT_FIRST_TIME, response.getData());
        return response;
    }

    @RequestMapping(value = "popup.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse popup(HttpSession session){
        Object obj = session.getAttribute(Const.NOT_FIRST_TIME);
        if(obj != null){
            return ServerResponse.createBySuccess("This is not the first time to visit");
        }
        return ServerResponse.createByErrorMessage("This is the first time to visit");
    }
}
