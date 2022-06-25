package com.example.hackathonbackend.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hackathonbackend.entity.Customerproduct;
import com.example.hackathonbackend.entity.ProductEntity;
import com.example.hackathonbackend.repository.CustomerProductRepository;
import com.example.hackathonbackend.repository.ProductRepository;

@Controller
@RequestMapping(value = "/ingredients")
public class HtmlController {
    private final ProductRepository productRepository;
    private final CustomerProductRepository customerProductRepository;

    public HtmlController(ProductRepository productRepository,
                          CustomerProductRepository customerProductRepository) {
        this.productRepository = productRepository;
        this.customerProductRepository = customerProductRepository;
    }

    @PostMapping("/basf/ingredients")
    public String postIngredientResult(@RequestBody List<String> ingredientsList, Model model ){
        List<String> example1 = Arrays.asList("Affinisphere C00465","stearyl alcohol");
        List<String> example2 = Arrays.asList("propylene glycol care","stearyl alcohol");
        List<String> ingredientList;
        Random rand = new Random();
        int max=4;
        int min=0;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        if(randomNum == 1){
            ingredientList = example1;
        }else {
            ingredientList = example2;
        }
        List<ProductEntity>  productIngredients = productRepository.findAll();
        List<String> finalIngredientList = ingredientList;
        List<ProductEntity>  selectedIngredients = new ArrayList<>();
         selectedIngredients = productIngredients.stream()
                .filter(productEntity -> finalIngredientList.contains(productEntity.getName()))
                .collect(Collectors.toList());
        List<String> names = new ArrayList<>();
        selectedIngredients.forEach(x-> names.add(x.getName()));
        List<Customerproduct> customerproducts = customerProductRepository.findAll();
        List<Customerproduct> similiarproducts = new ArrayList<>();
        similiarproducts = customerproducts.stream().filter(customerproduct -> {
            List<String> tempList =  Arrays.asList(customerproduct.getIngredients().split(",", -1));
            return tempList.stream().anyMatch(names::contains);
        }).collect(Collectors.toList());
        Set<Customerproduct> set = new LinkedHashSet<>(similiarproducts);
        similiarproducts.clear();
        similiarproducts.addAll(set);
        model.addAttribute("results",selectedIngredients);
        model.addAttribute("similarProducts",similiarproducts);
        return "result";
    }
}
