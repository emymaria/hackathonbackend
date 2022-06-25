package com.example.hackathonbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hackathonbackend.entity.HeatDataEntity;
import com.example.hackathonbackend.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
