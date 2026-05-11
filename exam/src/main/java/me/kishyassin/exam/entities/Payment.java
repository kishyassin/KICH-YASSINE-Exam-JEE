package me.kishyassin.exam.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private double amount;
    
    @Enumerated(EnumType.STRING)
    private PaymentType type;

    @ManyToOne
    private InsuranceContract contract;
}
