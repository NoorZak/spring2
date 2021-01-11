package com.example.spring2.productsandcategories.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="associations")
public class Association {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    public Association() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PostPersist
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

}