package me.kishyassin.exam.repositories;

import me.kishyassin.exam.entities.InsuranceContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceContractRepository extends JpaRepository<InsuranceContract, Long> {
}
