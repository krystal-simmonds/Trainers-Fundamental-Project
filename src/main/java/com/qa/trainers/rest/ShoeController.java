package com.qa.trainers.rest;

import com.qa.trainers.domain.Shoe;
import com.qa.trainers.dto.ShoeDTO;
import com.qa.trainers.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoeController {

    private final ShoeService shoeService;

    @Autowired
    public ShoeController(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ShoeDTO>> getAllShoes(){
        return ResponseEntity.ok(this.shoeService.seeAllShoes());
    }//Read functionality. See all shoes

    @PostMapping("/addShoe")
    public ResponseEntity<ShoeDTO> addShoe(@RequestBody Shoe shoe){
        return new ResponseEntity<>(this.shoeService.addShoe(shoe), HttpStatus.CREATED);
    }// Add/create functionality. Warning message appeared for line 30 saying explicit type argument. ShoeDTO can be replaced with <>

    @DeleteMapping("/delete/{shoeId}")
    public ResponseEntity<?> deleteShoe(@PathVariable Long shoeId){
        return this.shoeService.deleteShoeById(shoeId)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }// Delete functionality

    @GetMapping("/getShoeById/{shoeId}")
    public ResponseEntity<ShoeDTO> getShoeById(@PathVariable Long shoeId){
        return ResponseEntity.ok(this.shoeService.findShoeById(shoeId));
    }

    @PutMapping("/updateShoeSize/{shoeId}")
    public ResponseEntity<ShoeDTO> updateShoeSize(@PathVariable Long shoeId, @RequestBody Shoe shoe){
        return ResponseEntity.ok(this.shoeService.updateShoeSize(shoeId, shoe));
    }

}
