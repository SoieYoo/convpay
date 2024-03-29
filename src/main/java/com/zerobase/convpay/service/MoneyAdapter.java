package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CancelPaymentResult;
import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.type.PaymentResult;

public class MoneyAdapter implements PaymentInterface {
    //머니 사용
    public MoneyUseResult use(Integer payAmout) {
        System.out.println("MoneyAdapter.use");
        System.out.println("payAmout = " + payAmout);
        if(payAmout>1000_000) {
            return MoneyUseResult.USE_FAIL;
        }
        return MoneyUseResult.USE_SUCCESS;
    }
    //머니 사용 취소
    public MoneyUseCancelResult useCancel(Integer payCancelAmount) {
        System.out.println("MoneyAdapter.useCancel");
        System.out.println("payCancelAmount = " + payCancelAmount);

        if(payCancelAmount < 100) {
            return MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL;
        }
        return MoneyUseCancelResult.MONEY_USE_CANCEL_SUCCESS;
    }

    @Override
    public PaymentResult payment(Integer payAmount) {
        MoneyUseResult moneyUseResult = use(payAmount);

        if(moneyUseResult == MoneyUseResult.USE_FAIL) {
            return PaymentResult.PAYMENT_FAIL;
        }
        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public CancelPaymentResult cancelPayment(Integer cancelAmount) {
        MoneyUseCancelResult moneyUseCancelResult = useCancel(cancelAmount);
        if(moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL) {
            return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
        }
        return CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;
    }
}
