package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequest;

public class DiscountByPayMethod implements DiscountInterface{
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        switch (payRequest.getPayMethodType()) {
            case MONEY -> {
                return payRequest.getPayAmout() * 7 / 10;
            }
            case CARD -> {
                return payRequest.getPayAmout();
            }
        }
        return payRequest.getPayAmout();
    }
}
