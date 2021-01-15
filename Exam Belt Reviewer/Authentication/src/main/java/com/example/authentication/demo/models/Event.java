package com.example.authentication.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Future
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date eventDate;
    @NotEmpty
    private String name;
    @NotEmpty
    private String city;

    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="event", cascade = CascadeType.REMOVE)
    private List<Message> messages;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User planner;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name="users_events",
            joinColumns = @JoinColumn(name="event_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private List<User> attendees;


    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    public String getEventDateFormatted() {
        SimpleDateFormat df = new SimpleDateFormat("dd,MM,YYYY");
        return df.format(this.eventDate);
    }
    public Event() {

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getEventDate() {
        return eventDate;
    }
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public List<Message> getMessages() {
        return messages;
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    public User getPlanner() {
        return planner;
    }
    public void setPlanner(User planner) {
        this.planner = planner;
    }
    public List<User> getAttendees() {
        return attendees;
    }
    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }
}