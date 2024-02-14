package com.zerobase.convpay;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;

public class UserClient {
    public static void main(String[] args) {
        ConveniencePayService conveniencePayService = new ConveniencePayService();

        // 결제 1000원
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);
        PayResponse payResponse = conveniencePayService.pay(payRequest);
        System.out.println("payResponse = " + payResponse);

        // 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.CARD, ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
        System.out.println("payCancelResponse = " + payCancelResponse);
    }
}
