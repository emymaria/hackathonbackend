package com.example.hackathonbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Tables;

@Entity
@Table(name = "heat_data")
public class HeatDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "latitude")
    private float latitude;
    @Column(name = "longitude")
    private float longitude;
    @Column(name = "count")
    private int count;

    public HeatDataEntity() {
    }

    public HeatDataEntity(long id, long latitude, long longitude, int count) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
