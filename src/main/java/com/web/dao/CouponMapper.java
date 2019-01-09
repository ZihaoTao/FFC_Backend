package com.web.dao;

import com.web.pojo.Coupon;

import java.util.List;

/**
 * Created by tino on 1/8/19.
 */
public interface CouponMapper {
    int insert(Coupon record);

    int insertSelective(Coupon record);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);

    Coupon selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    List<Coupon> selectList();
}
