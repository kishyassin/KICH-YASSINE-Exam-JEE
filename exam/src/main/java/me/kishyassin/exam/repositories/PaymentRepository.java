package me.kishyassin.exam.repositories;

import me.kishyassin.exam.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
