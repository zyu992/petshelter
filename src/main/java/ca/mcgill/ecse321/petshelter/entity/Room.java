package ca.mcgill.ecse321.petshelter.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private Integer roomId;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "message")
    private List<Message> messages;

    @ManyToMany
    @JoinTable(name = "user")
    private List<User> users;
    
    public Integer getRoomId() {return roomId;}

    public void setRoomId(Integer pRoomId) {roomId = pRoomId;}

    public List<Message> getMessages() {return messages;}

    public void setMessages(List<Message> pMessages) {messages = pMessages;}

    public List<User> getUsers() {return users;}

    public void setUsers(List<User> pUsers) {users = pUsers;}
}
