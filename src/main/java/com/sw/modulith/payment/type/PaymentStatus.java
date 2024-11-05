package com.sw.modulith.payment.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {
    COMPLETED("C"), NOT_COMPLETED("NC"), FAILED("F");

    private final String code;
}