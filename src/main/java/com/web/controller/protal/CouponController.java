package com.web.controller.protal;

import com.web.common.Const;
import com.web.common.ServerResponse;
import com.web.pojo.User;
import com.web.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by tino on 1/8/19.
 */
@Controller
@RequestMapping("/coupon/")
public class CouponController {

    @Autowired
    private ICouponService iCouponService;

    @RequestMapping(value = "addDefaultCoupon.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addDefaultCoupon(HttpSession session, @RequestParam(value = "percent") int percent){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user != null){

            return iCouponService.addDefaultCoupon(user.getId(), percent + "%");

        }
        return ServerResponse.createByErrorMessage("Need to login");
    }
}
