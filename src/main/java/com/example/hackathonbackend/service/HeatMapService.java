package com.example.hackathonbackend.service;

import java.util.List;

import com.example.hackathonbackend.entity.HeatDataEntity;

public interface HeatMapService {
    List<HeatDataEntity> findAllHeatData();
    List<HeatDataEntity> saveAllHeatData(List<HeatDataEntity> heatDataList);
    void deleteCurrentData();
}
