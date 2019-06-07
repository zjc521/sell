package com.imooc.sell.dataobject;

import com.imooc.sell.enums.OrderSatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    //订单id
    @Id
    private String OrderId;
    //订单名称
    private String buyerName;
    //买家手机号
    private String buyerPhone;
    //买家地址
    private String buyerAddress;
    //买家微信Openid
    private String buyerOpenid;
    //订单总金额
    private BigDecimal orderAmount;
    //订单状态，默认为下单
    private Integer orderStatus = OrderSatusEnum.NEW.getCode();
    //支付状态，默认为0未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
   //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

}
