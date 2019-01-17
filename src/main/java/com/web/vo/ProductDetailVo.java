package com.web.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by tino on 10/13/18.
 */

@Getter
@Setter
@NoArgsConstructor
public class ProductDetailVo {

    private Integer id;
    private Integer categoryId;
    private String name;
    private String subtitle;
    private String mainImage;
    private String subImages;
    private String sku;
    private String detail;
    private String color;
    private String fromWhere;
    private String howMade;
    private String sizeRange;
    private String goal;
    private String cause;
    private BigDecimal price;
    private Integer stock;
    private Integer status;
    private String createTime;
    private String updateTime;
    private String imageHost;
    private Integer parentCategoryId;

}

