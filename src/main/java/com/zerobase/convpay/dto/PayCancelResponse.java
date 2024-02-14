package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayCancelResult;
import lombok.Data;

@Data
public class PayCancelResponse {
    PayCancelResult payCancelResult;
    Integer payCanceledAmount;

    public PayCancelResponse(PayCancelResult payCancelResult, Integer payCanceledAmount) {
        this.payCancelResult = payCancelResult;
        this.payCanceledAmount = payCanceledAmount;
    }
}
