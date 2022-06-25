package com.example.hackathonbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_data")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long product_id;
    @Column(name = "name")
    private String name;
    @Column(name = "sustainability_score")
    private String sustainabilityScore;
    @Column(name = "product_segments")
    private String productSegments;
    public ProductEntity() {
    }

    public ProductEntity(long product_id, String name, String sustainabilityScore, String productSegments) {
        this.product_id = product_id;
        this.name = name;
        this.sustainabilityScore = sustainabilityScore;
        this.productSegments = productSegments;
    }

    public String getProductSegments() {
        return productSegments;
    }

    public void setProductSegments(String productSegments) {
        this.productSegments = productSegments;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSustainabilityScore() {
        return sustainabilityScore;
    }

    public void setSustainabilityScore(String value) {
        this.sustainabilityScore = value;
    }
}
