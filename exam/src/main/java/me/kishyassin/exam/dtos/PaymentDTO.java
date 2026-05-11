package me.kishyassin.exam.dtos;

import lombok.Data;
import me.kishyassin.exam.entities.PaymentType;
import java.util.Date;

@Data
public class PaymentDTO {
    private Long id;
    private Date date;
    private double amount;
    private PaymentType type;
}
