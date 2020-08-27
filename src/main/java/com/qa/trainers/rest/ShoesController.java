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

    @PostMapping("/addShoe")
    public Shoe addShoe(@RequestBody Shoe shoe){
        return this.shoeService.addShoe(shoe);
    }

    @DeleteMapping("/delete/{shoeId}")
    public Boolean deleteShoe(@PathVariable Long shoeId){
        return this.shoeService.deleteShoeById(shoeId);
    }

    @GetMapping("/getShoeById/{shoeId}")
    public Shoe getShoeById(@PathVariable Long shoeId){
        return this.shoeService.findShoeById(shoeId);
    }

    @PutMapping("/updateShoeSize/{shoeId}")
    public Shoe updateShoeSize(@PathVariable Long shoeId, @RequestBody Shoe shoe){
        return this.shoeService.updateShoe(shoeId, shoe);
    }

}
