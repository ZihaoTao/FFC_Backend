package com.web.controller.protal;

import com.github.pagehelper.PageInfo;
import com.web.common.Const;
import com.web.common.ServerResponse;
import com.web.pojo.User;
import com.web.service.ICouponService;
import com.web.service.IUserService;
import com.web.util.CookieUtil;
import com.web.util.JsonUtil;
import com.web.util.RedisShardedPoolUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tino on 1/8/19.
 */
@Controller
@RequestMapping("/coupon/")
public class CouponController {

    @Autowired
    private ICouponService iCouponService;

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "addCoupon.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addCoupon(HttpServletRequest httpServletRequest, @RequestParam(value = "percent") int percent){
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)) {
            return ServerResponse.createByErrorMessage("Need to login");
        }
        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
        User currentUser = JsonUtil.String2Obj(userJsonStr, User.class);
        if(currentUser != null){
            return iCouponService.addCoupon(currentUser.getId(), percent + "%");
        }
        return ServerResponse.createByErrorMessage("Need to login");
    }

    @RequestMapping(value = "addDefaultCoupon.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addDefaultCoupon(HttpServletRequest httpServletRequest){
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)) {
            return ServerResponse.createByErrorMessage("Need to login");
        }
        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
        User currentUser = JsonUtil.String2Obj(userJsonStr, User.class);
        if(currentUser != null){
            if(currentUser.getFirstTimeGetCoupon() == 0) {
                currentUser.setFirstTimeGetCoupon(Const.FirstTimeGetCoupon.NO);
                iUserService.updateInformation(currentUser);
                return iCouponService.addCoupon(currentUser.getId(), "10%");
            }
            return ServerResponse.createByErrorMessage("User has gotten the first coupon");
        }
        return ServerResponse.createByErrorMessage("Need to login");
    }

    @RequestMapping(value = "couponList.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> couponList(HttpServletRequest httpServletRequest, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        String loginToken = CookieUtil.readLoginToken(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)) {
            return ServerResponse.createByErrorMessage("Need to login");
        }
        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
        User currentUser = JsonUtil.String2Obj(userJsonStr, User.class);
        if(currentUser != null){
            return iCouponService.getCouponList(currentUser.getId(), pageNum, pageSize);
        }
        return ServerResponse.createByErrorMessage("Need to login");
    }

}
