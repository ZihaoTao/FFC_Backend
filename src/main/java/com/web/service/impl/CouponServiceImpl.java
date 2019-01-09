package com.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.web.common.Const;
import com.web.common.ResponseCode;
import com.web.common.ServerResponse;
import com.web.dao.CouponMapper;
import com.web.pojo.Coupon;
import com.web.service.ICouponService;
import com.web.util.DateTimeUtil;
import com.web.vo.CouponListVo;
import com.web.vo.UserListVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tino on 1/8/19.
 */

@Service("iCouponService")
public class CouponServiceImpl implements ICouponService{

    @Autowired
    private CouponMapper couponMapper;

    @Override
    public ServerResponse<String> addCoupon(Integer userId, String discount) {
        if(StringUtils.isEmpty(discount)) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        Coupon coupon = new Coupon();
        coupon.setUserId(userId);
        coupon.setStatus(Const.CouponStatus.UNUSED);
        coupon.setDiscount(discount);

        int resultCount = couponMapper.insert(coupon);

        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("Add coupon failed");
        }
        return ServerResponse.createBySuccessMessage("Add coupon successful");
    }

    @Override
    // use mybatis page helper plugin
    public ServerResponse<PageInfo> getCouponList(int pageNum, int pageSize) {
        // startPage--start
        PageHelper.startPage(pageNum, pageSize);
        List<Coupon> list = couponMapper.selectList();
        // how to request sql
        List<CouponListVo> couponListVos = Lists.newArrayList();
        for (Coupon couponItem : list) {
            couponListVos.add(assembleCouponListVo(couponItem));
        }
        // pageHelper ending
        PageInfo pageResult = new PageInfo(list);
        pageResult.setList(couponListVos);
        return ServerResponse.createBySuccess(pageResult);
    }

    private CouponListVo assembleCouponListVo(Coupon coupon) {
        CouponListVo couponListVo = new CouponListVo();
        couponListVo.setId(coupon.getId());
        couponListVo.setUserId(coupon.getUserId());
        couponListVo.setDiscount(coupon.getDiscount());
        couponListVo.setStatus(coupon.getStatus());
        couponListVo.setCreateTime(DateTimeUtil.dateToStr(coupon.getCreateTime()));
        return couponListVo;
    }
}
