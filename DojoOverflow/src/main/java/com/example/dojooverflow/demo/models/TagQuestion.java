package com.example.dojooverflow.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tag_question")
public class TagQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tag_id")
    private Tag tag;

    public TagQuestion() {

    }

    public TagQuestion(Long id, Question question, Tag tag) {
        this.id = id;
        this.question = question;
        this.tag = tag;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Question getQuestion() {
        return question;
    }

    public Tag getTag() {
        return tag;
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