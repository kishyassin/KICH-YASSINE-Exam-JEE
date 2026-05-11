package me.kishyassin.exam.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@DiscriminatorValue("AUTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AutoInsuranceContract extends InsuranceContract {
    private String registrationNumber;
    private String brand;
    private String model;
}
