package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import lombok.Data;

@Data
public class PayRequest {
    //결제 수단
    PayMethodType payMethodType;

    //편의점 종류
    ConvenienceType convenienceType;

    //결제 금액
    Integer payAmout;

    public PayRequest(ConvenienceType convenienceType, Integer payAmout) {
        this.convenienceType = convenienceType;
        this.payAmout = payAmout;
    }

    public PayRequest(PayMethodType payMethodType, ConvenienceType convenienceType, Integer payAmout) {
        this.payMethodType = payMethodType;
        this.convenienceType = convenienceType;
        this.payAmout = payAmout;
    }
}
