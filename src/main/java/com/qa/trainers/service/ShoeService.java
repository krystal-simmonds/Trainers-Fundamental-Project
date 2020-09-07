package com.qa.trainers.service;

import com.qa.trainers.domain.Shoe;
import com.qa.trainers.dto.ShoeDTO;
import com.qa.trainers.exceptions.ShoeNotFoundException;
import com.qa.trainers.repo.ShoeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoeService {

    private final ShoeRepository shoeRepo;

    private final ModelMapper mapper;

    @Autowired
    public ShoeService(ShoeRepository shoeRepo, ModelMapper mapper){
        this.shoeRepo = shoeRepo;
        this.mapper = mapper;
    }

    private ShoeDTO mapToDTO(Shoe shoe){
           return this.mapper.map(shoe, ShoeDTO.class);
        }

    public List<ShoeDTO> seeAllShoes() {
        return this.shoeRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    } //see (read) all shoes


    public ShoeDTO addShoe(Shoe shoe){
        return this.mapToDTO(this.shoeRepo.save(shoe));
    } // add (create) shoe

    public ShoeDTO findShoeById(Long shoeId){
        return this.mapToDTO(this.shoeRepo.findById(shoeId).orElseThrow(ShoeNotFoundException::new));
    } //find shoe by ID

    public ShoeDTO updateShoeSize(Long shoeId, Shoe shoe){
        Shoe update = this.shoeRepo.findById(shoeId).orElseThrow(ShoeNotFoundException::new);
        update.setShoeSize(shoe.getShoeSize());
        return this.mapToDTO(this.shoeRepo.save(shoe));
    } //update shoe size

    public Boolean deleteShoeById(Long shoeId){
        if(!this.shoeRepo.existsById(shoeId)){
            throw new ShoeNotFoundException();
        }
        this.shoeRepo.deleteById(shoeId);
        return this.shoeRepo.existsById(shoeId);
    } // delete shoe

}
