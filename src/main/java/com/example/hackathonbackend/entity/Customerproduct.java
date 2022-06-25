package com.example.hackathonbackend.entity;

import java.net.URL;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name = "customer_product_data")
public class Customerproduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_product_id")
    private long product_id;
    @Column(name = "name")
    private String name;
    @Column(name = "ingredients")
    @Lob
    private String ingredients;
    @Column(name = "sustainability_meter")
    private String sustainabilityMeter;
    @Column(name = "link")
    @Lob
    private URL link;

    public Customerproduct() {
    }

    public Customerproduct(long product_id, String name, String ingredients, String sustainabilityMeter, URL link) {
        this.product_id = product_id;
        this.name = name;
        this.ingredients = ingredients;
        this.sustainabilityMeter = sustainabilityMeter;
        this.link = link;
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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSustainabilityMeter() {
        return sustainabilityMeter;
    }

    public void setSustainabilityMeter(String sustainabilityMeter) {
        this.sustainabilityMeter = sustainabilityMeter;
    }

    public URL getLink() {
        return link;
    }

    public void setLink(URL link) {
        this.link = link;
    }
}
