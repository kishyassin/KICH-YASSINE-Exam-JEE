package me.kishyassin.exam.dtos;

import lombok.Data;
import me.kishyassin.exam.entities.ContractStatus;
import java.util.Date;

@Data
public abstract class InsuranceContractDTO {
    private Long id;
    private Date subscriptionDate;
    private ContractStatus status;
    private Date validationDate;
    private double contributionAmount;
    private int duration;
    private double coverageRate;
    private String type; // To identify the subclass in the frontend
}
