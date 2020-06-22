package ca.mcgill.ecse321.petshelter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@NoArgsConstructor
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

    @ManyToOne(optional = false)
    @JoinColumn
    @JsonIgnoreProperties("receivedMessages")
    private User receiver;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Timestamp time;

    @Column(name = "room_id", nullable = false)
    private Integer roomId;
}