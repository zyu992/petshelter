package ca.mcgill.ecse321.petshelter.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    @Column(name = "payment_id")
    private Integer paymentId;

    @Column(name = "credit_card", nullable = false)
    private Integer creditCard;

    @Column(nullable = false)
    private Timestamp time;

    @Column(nullable = false)
    private Integer amount;

    @ManyToOne(optional = false)
    @JoinColumn
    private User payer;
}