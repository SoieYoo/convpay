package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

//ctrl option o => import 최적화
//option cmd L => 코드정리
//cmd shift T => 테스트 이동
//편의점 결제 서비스(편결이)
public class ConveniencePayService {
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private final CardAdapter cardAdapter = new CardAdapter();

    //정책이 결제수단으로 할인하는 것으로 정해짐!
    private final DiscountInterface discountInterface = new DiscountByPayMethod();

    //결제
    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface;

        if(payRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequest);

        PaymentResult paymentResult = paymentInterface.payment(discountedAmount);

        if(paymentResult == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }
        return new PayResponse(PayResult.SUCCESS, discountedAmount);
    }

    //결제 취소
    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface;

        if(payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }
        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        if(cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
