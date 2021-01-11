package com.example.dojooverflow.demo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;



    public Answer() {
    }

    public Answer(Long id, String text) {
        this.id = id;
        this.text = text;
    }



    public Question getQuestion() {
        return question;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }


    public void setQuestion(Question question) {
        this.question = question;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}