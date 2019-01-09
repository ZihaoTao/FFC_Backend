package com.web.service.impl;

import com.web.common.Const;
import com.web.common.ResponseCode;
import com.web.common.ServerResponse;
import com.web.dao.CouponMapper;
import com.web.pojo.Coupon;
import com.web.service.ICouponService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tino on 1/8/19.
 */

@Service("iCouponService")
public class CouponServiceImpl implements ICouponService{

    @Autowired
    private CouponMapper couponMapper;

    @Override
    public ServerResponse<String> addDefaultCoupon(Integer userId, String discount) {
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
}
