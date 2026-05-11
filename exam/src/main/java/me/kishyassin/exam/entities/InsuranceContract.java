package me.kishyassin.exam.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 20)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class InsuranceContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date subscriptionDate;
    
    @Enumerated(EnumType.STRING)
    private ContractStatus status;
    
    private Date validationDate;
    private double contributionAmount;
    private int duration; // in months
    private double coverageRate;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "contract")
    private List<Payment> payments;
}
