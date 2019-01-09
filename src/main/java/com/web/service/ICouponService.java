package com.web.service;

import com.github.pagehelper.PageInfo;
import com.web.common.ServerResponse;

/**
 * Created by tino on 1/8/19.
 */
public interface ICouponService {
    ServerResponse<String> addCoupon (Integer userId, String discount);

    ServerResponse<PageInfo> getCouponList(int pageNum, int pageSize);
}
