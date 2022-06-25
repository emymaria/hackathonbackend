package com.example.hackathonbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hackathonbackend.entity.Customerproduct;
import com.example.hackathonbackend.entity.ProductEntity;

@Repository
public interface CustomerProductRepository extends JpaRepository<Customerproduct,Long> {
}
