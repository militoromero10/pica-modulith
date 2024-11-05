package com.sw.modulith.payment;

import com.sw.modulith.payment.type.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@ToString
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bikerId;
    private Double amount;
    private Timestamp paymentDate = Timestamp.from(Instant.now());
    private PaymentStatus status = PaymentStatus.NOT_COMPLETED;
}
