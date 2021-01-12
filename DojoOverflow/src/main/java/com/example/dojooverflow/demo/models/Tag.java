package com.example.dojooverflow.demo.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tag")

public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size( max = 255)
    private String subject;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tag_question",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;

    public Tag() {
    questions= new ArrayList<Question>() ;

    }

    public Tag(Long id, String subject) {
        questions= new ArrayList<Question>() ;

        this.id = id;
        this.subject = subject;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
