package me.kishyassin.exam.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AutoInsuranceContractDTO extends InsuranceContractDTO {
    private String registrationNumber;
    private String brand;
    private String model;
}
