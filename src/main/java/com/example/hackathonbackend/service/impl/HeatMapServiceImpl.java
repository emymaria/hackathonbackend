package com.example.hackathonbackend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hackathonbackend.entity.HeatDataEntity;
import com.example.hackathonbackend.repository.HeatDataRepository;
import com.example.hackathonbackend.service.HeatMapService;

@Service
public class HeatMapServiceImpl implements HeatMapService {

    private final HeatDataRepository heatDataRepository;

    public HeatMapServiceImpl(HeatDataRepository heatDataRepository) {
        this.heatDataRepository = heatDataRepository;
    }

    @Override
    public List<HeatDataEntity> findAllHeatData() {
        return heatDataRepository.findAll();
    }

    @Override
    public List<HeatDataEntity> saveAllHeatData(List<HeatDataEntity> heatDataList) {
        heatDataList.forEach(data -> System.out.println(data.getLatitude()));
        return heatDataRepository.saveAll(heatDataList);
    }

    @Override
    public void deleteCurrentData() {
         heatDataRepository.deleteAll();
    }
}
