package me.kishyassin.exam.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@DiscriminatorValue("HOME")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HomeInsuranceContract extends InsuranceContract {
    @Enumerated(EnumType.STRING)
    private HousingType housingType;
    private String address;
    private double area;
}
