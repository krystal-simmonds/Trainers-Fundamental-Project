package com.qa.trainers.rest;

import com.qa.trainers.domain.Shoe;
import com.qa.trainers.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoesController {

    private final ShoeService shoeService;

    @Autowired
    public ShoesController(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    @GetMapping("/")
    public List<Shoe> getAllShoes(){
        return this.shoeService.seeAllShoes(); //Read functionality
    }

}
