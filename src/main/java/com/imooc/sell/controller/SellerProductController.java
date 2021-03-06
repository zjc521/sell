package com.imooc.sell.controller;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.service.ProductService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 卖家端商品
 *
 */

@Controller
@RequestMapping("/seller/product")
public class SellerProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){
        PageRequest request = new PageRequest(page-1,size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        map.put("productInfoPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("product/list",map);

    }
    /**
     * 商品上架
     * @Author zhangjincai
     * @Description //TODO
     * @Date 14:39 2019/8/27
     * @Param [productId, map]
     * @return org.springframework.web.servlet.ModelAndView
     */
    @GetMapping("on_sale")
    public ModelAndView onSale(@RequestParam("productId")String productId,
                               Map<String,Object> map){
        try {
            productService.onSale(productId);
        }catch(SellException e){
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }
            map.put("url","/sell/seller/product/list");

        return  new ModelAndView("common/success",map);
    }
    /**
     * 商品下架
     * @Author zhangjincai
     * @Description //TODO
     * @Date 14:40 2019/8/27
     * @Param
     * @return
     */
    @GetMapping("off_sale")
    public ModelAndView offSale(@RequestParam("productId")String productId,
                                Map<String,Object> map){
        try{
            productService.offSale(productId);
        }catch (SellException e){

            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/success",map);
    }

}
