package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productinfo=new ProductInfo();
        productinfo.setProductId("123123");
        productinfo.setProductName("八宝粥");
        productinfo.setProductPrice(new BigDecimal(6));
        productinfo.setProductStock(100);
        productinfo.setProductDescription("好顶");
        productinfo.setProductIcon("http://123.jpg");
        productinfo.setCategoryType(2);
        ProductInfo result = repository.save(productinfo);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> productInfoList=repository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }
}