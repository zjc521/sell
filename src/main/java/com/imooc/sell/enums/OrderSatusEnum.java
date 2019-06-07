package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum OrderSatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
     ;
    private Integer code;
    private String message;

    OrderSatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
