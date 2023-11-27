package com.example.cardapio.controller;

import com.example.cardapio.entity.Food;
import com.example.cardapio.entity.FoodRepository;
import com.example.cardapio.entity.FoodRequestDTO;
import com.example.cardapio.entity.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository repository;

    public FoodController(FoodRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repository.findAll()
                .stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }


}
