package com.sw.modulith.payment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface PaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment> getPaymentByBikerId(Long id);
}
