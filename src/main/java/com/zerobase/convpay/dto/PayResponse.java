package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayResult;
import lombok.Data;

@Data
public class PayResponse {
    // 결제 결과
    PayResult payResult;

    // 결제 성공 금액
    Integer paidAmout;

    public PayResponse(PayResult payResult, Integer paidAmout) {
        this.payResult = payResult;
        this.paidAmout = paidAmout;
    }

}
