package com.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Created by tino on 1/8/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
    private Integer id;

    private Integer userId;

    private Integer status;

    private String discount;

    private Date createTime;

    private Date updateTime;
}
