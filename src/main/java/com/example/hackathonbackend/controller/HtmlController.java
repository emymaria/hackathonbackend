package com.example.hackathonbackend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hackathonbackend.entity.ProductEntity;
import com.example.hackathonbackend.repository.ProductRepository;

@Controller
@RequestMapping(value = "/ingredients")
public class HtmlController {
    private final ProductRepository productRepository;

    public HtmlController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/basf/ingredients")
    public String postIngredientResult(@RequestBody List<String> ingredientList, Model model ){
        List<ProductEntity>  productIngredients = productRepository.findAll();
        List<ProductEntity>  selectedIngredients = productIngredients.stream().filter(productEntity -> ingredientList.contains(productEntity.getName())).collect(
                Collectors.toList());
        model.addAttribute("result",selectedIngredients);
        return "result";
    }
}
