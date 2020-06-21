package ca.mcgill.ecse321.petshelter.entity;

import java.sql.Timestamp;

public class PaymentHistory {
    private Integer paymentId;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Integer creditCard) {
        this.creditCard = creditCard;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    private Integer creditCard;
    private Timestamp time;
    private Integer amount;
    private User payer;
}