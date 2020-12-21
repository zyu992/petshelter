package ca.mcgill.ecse321.petshelter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "message_id")
    private Integer messageId;

    @ManyToOne(optional = false)
    @JoinColumn
    @JsonIgnoreProperties("sentMessages")
    private User sender;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Timestamp time;

    @Column(name = "room_id", nullable = false)
    private Integer roomId;

    public Integer getMessageId() {return messageId;}

    public void setMessageId(Integer pMessageId) {messageId = pMessageId;}

    public User getSender() { return sender;}

    public void setSender(User pSender) {sender = pSender;}

    public String getContent() {return content;}

    public void setContent(String pContent) {content = pContent;}

    public Timestamp getTime() {return time;}

    public void setTime(Timestamp pTime){time = pTime;}

    public Integer getRoomId() {return roomId;}

    public void setRoomId(Integer pRoomId) {roomId = pRoomId;}
}