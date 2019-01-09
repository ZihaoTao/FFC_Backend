package com.web.service;

import com.web.common.ServerResponse;

/**
 * Created by tino on 1/8/19.
 */
public interface ICouponService {
    ServerResponse<String> addDefaultCoupon (Integer userId, String discount);
}
