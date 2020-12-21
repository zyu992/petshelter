package ca.mcgill.ecse321.petshelter.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue
    @Column(name = "payment_id")
    private Integer paymentId;

    @Column(name = "confirmation_number", nullable = false)
    private String confirmation;

    @Column(nullable = false)
    private Timestamp time;

    @Column(nullable = false)
    private Double amount;

    @ManyToOne(optional = false)
    @JoinColumn
    private User payer;

    public Integer getPaymentId() {return paymentId;}

    public void setPaymentId(Integer pPaymentId) {paymentId = pPaymentId;}

    public String getConfirmation() {return confirmation;}

    public void setConfirmation(String pConfirmation) {confirmation = pConfirmation;}

    public Timestamp getTime() {return time;}

    public void setTime(Timestamp pTime) {time = pTime;}

    public Double getAmount() {return amount;}

    public void setAmount(Double pAmount) {amount = pAmount;}

    public User getPayer() {return payer;}

    public void setPayer(User pPayer) {payer = pPayer;}
}