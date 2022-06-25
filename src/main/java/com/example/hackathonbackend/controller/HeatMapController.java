package com.example.hackathonbackend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackathonbackend.entity.HeatDataEntity;
import com.example.hackathonbackend.entity.ProductEntity;
import com.example.hackathonbackend.repository.ProductRepository;
import com.example.hackathonbackend.service.HeatMapService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/hackathon")
public class HeatMapController {

    private final HeatMapService heatMapService;
    private final ProductRepository productRepository;

    public HeatMapController(HeatMapService heatMapService, ProductRepository productRepository) {
        this.heatMapService = heatMapService;
        this.productRepository = productRepository;
    }

    @PostMapping("/heatmap")
    public List<HeatDataEntity> saveHeatData(@RequestBody List<HeatDataEntity> heatDataEntityList){
        System.out.println(heatDataEntityList.size());
        heatDataEntityList.forEach(data->{
            System.out.println(data.getCount());
        });
        return heatMapService.saveAllHeatData(heatDataEntityList);
    }

    @DeleteMapping("/heatmap")
    public void deleteData(){
        heatMapService.deleteCurrentData();
    }

    @GetMapping("/heatmap")
    public List<HeatDataEntity> getData(){
        return heatMapService.findAllHeatData();
    }


    @PostMapping("/basf/db/ingredients")
    public void postIngredients(@RequestBody List<ProductEntity> productlist ){
        productRepository.saveAll(productlist);
    }

    @GetMapping("/basf/ingredients")
    public List<ProductEntity> getIngredients(){
        return productRepository.findAll();
    }
}

