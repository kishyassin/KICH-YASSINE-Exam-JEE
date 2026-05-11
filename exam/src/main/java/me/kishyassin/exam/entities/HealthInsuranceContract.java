package me.kishyassin.exam.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@DiscriminatorValue("HEALTH")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HealthInsuranceContract extends InsuranceContract {
    @Enumerated(EnumType.STRING)
    private CoverageLevel coverageLevel;
    private int personsCovered;
}
