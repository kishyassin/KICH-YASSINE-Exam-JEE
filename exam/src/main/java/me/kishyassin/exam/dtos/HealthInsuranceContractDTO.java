package me.kishyassin.exam.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.kishyassin.exam.entities.CoverageLevel;

@Data
@EqualsAndHashCode(callSuper = true)
public class HealthInsuranceContractDTO extends InsuranceContractDTO {
    private CoverageLevel coverageLevel;
    private int personsCovered;
}
