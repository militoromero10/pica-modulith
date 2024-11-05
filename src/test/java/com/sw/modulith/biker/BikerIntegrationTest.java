package com.sw.modulith.biker;

import com.sw.modulith.biker.dto.BikerDto;
import com.sw.modulith.biker.dto.BikerPaymentDto;
import com.sw.modulith.biker.dto.BikerResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.sql.Timestamp;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest(mode = ApplicationModuleTest.BootstrapMode.DIRECT_DEPENDENCIES)
public class BikerIntegrationTest {

    @Autowired
    BikerService bikerService;

    @Test
    void verifyModule(){

        BikerDto bikerDto = new BikerDto(123L, 10203040L, "test", new Timestamp(System.currentTimeMillis()));

        BikerResponseDto response = bikerService.createBiker(bikerDto);
        assertThat(response.message()).isEqualTo("Challenges currently processed");
        assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test
    void publishBikerPaymentDto(Scenario scenario) {

        scenario.publish(new BikerPaymentDto(UUID.randomUUID().toString(), 5000D))
                .andWaitForEventOfType(BikerPaymentDto.class)
                .matching(event -> event.amount() == 5000D)
                .toArriveAndVerify(ev -> System.out.println(ev.amount()));

    }
}
