package me.kishyassin.exam.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.kishyassin.exam.entities.HousingType;

@Data
@EqualsAndHashCode(callSuper = true)
public class HomeInsuranceContractDTO extends InsuranceContractDTO {
    private HousingType housingType;
    private String address;
    private double area;
}
