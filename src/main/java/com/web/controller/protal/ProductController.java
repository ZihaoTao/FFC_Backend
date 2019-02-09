package com.web.controller.protal;

import com.google.gson.Gson;
import com.web.common.ServerResponse;
import com.web.service.IProductService;
import com.web.service.impl.CategoryServiceImpl;
import com.web.vo.ProductDetailVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tino on 10/16/18.
 */
@Controller
@RequestMapping("/product/")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private IProductService iProductService;

    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(Integer productId) {
        return iProductService.getProductDetail(productId);
    }

    @RequestMapping("list.do")
    @ResponseBody
    public String list(@RequestParam("callback") String callback,
                       @RequestParam(value = "keyword", required = false) String keyword,
                       @RequestParam(value = "categoryId", required = false) Integer categoryId,
                       @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                       @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                       @RequestParam(value = "orderBy", defaultValue = "") String orderBy) {
        Gson gson=new Gson();
        logger.info(callback);
        return callback+ "(" + gson.toJson(iProductService.getProductByKeywordCategory(keyword, categoryId, pageNum, pageSize, orderBy)) + ")";
    }

    @RequestMapping("all.do")
    @ResponseBody
    public String all(@RequestParam("callback") String callback,
                                        @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                        @RequestParam(value = "orderBy", defaultValue = "") String orderBy) {
        Gson gson=new Gson();
        logger.info(callback);
        return callback+ "(" + gson.toJson(iProductService.getAllProduct(pageNum, pageSize, orderBy)) + ")";
    }
}
