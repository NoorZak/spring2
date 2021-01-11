package com.spring2.driverslicense.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="license")
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;
    private String state;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    public License() {

    }

    public License(Long id, Integer number, Date expirationDate, String state, Person person) {
        this.id = id;
        this.number = number;
        this.expirationDate = expirationDate;
        this.state = state;
        this.person = person;
    }

    public Long getId() {
        return id;
    }


    public String getNumberAsString() {
        int numZeros = 7 - String.valueOf(this.number).length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numZeros; i++)
            sb.append('0');
        return String.format("%s%d", sb, this.number);
    }

    public int getNumber() {
        return number;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getState() {
        return state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Person getPerson() {
        return person;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    // ...
    // getters and setters removed for brevity
    // ...
}