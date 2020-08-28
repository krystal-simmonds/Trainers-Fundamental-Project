package com.qa.trainers.service;

import com.qa.trainers.domain.Shoe;
import com.qa.trainers.exceptions.ShoeNotFoundException;
import com.qa.trainers.repo.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoeService {

    private final ShoeRepository shoeRepo;

    @Autowired
    public ShoeService(ShoeRepository shoeRepo){
        this.shoeRepo = shoeRepo;
    }

    public List<Shoe> seeAllShoes(){
        return this.shoeRepo.findAll();
    } //show all shoes

    public Shoe addShoe(Shoe shoe){
        return this.shoeRepo.save(shoe);
    } // add shoe

    public Shoe findShoeById(Long shoeId){
        return this.shoeRepo.findById(shoeId).orElseThrow(ShoeNotFoundException::new); // find shoe by ID
    }

    public Shoe updateShoe(Long shoeId, Shoe shoe){ // update shoe size
        Shoe update = findShoeById(shoeId);
        update.setShoeSize(shoe.getShoeSize());
        return this.shoeRepo.save(update);
    }

    public Boolean deleteShoeById(Long shoeId){
        if(!this.shoeRepo.existsById(shoeId)){
            throw new ShoeNotFoundException();
        }
        this.shoeRepo.deleteById(shoeId);
        return this.shoeRepo.existsById(shoeId); // delete shoe
    }

}
