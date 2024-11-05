package com.sw.modulith.biker;

import com.sw.modulith.biker.dto.BikerPaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BikerEventService {

    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void completeBiker(final BikerPaymentDto bikerPaymentDto) {

        log.info("Completing biker with details{}", bikerPaymentDto);
        eventPublisher.publishEvent(bikerPaymentDto);
    }
}
