package com.example.hackathonbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hackathonbackend.entity.HeatDataEntity;

@Repository
public interface HeatDataRepository extends JpaRepository<HeatDataEntity,Long> {

}
