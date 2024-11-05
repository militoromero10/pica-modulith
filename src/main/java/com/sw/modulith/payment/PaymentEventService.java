package com.sw.modulith.payment;

import com.sw.modulith.biker.dto.BikerPaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentEventService {

    private final PaymentRepository paymentRepository;

    @ApplicationModuleListener
    void on(final BikerPaymentDto paymentDto) {
        log.info("Biker payment received in listener: {}", paymentDto);
    }
}