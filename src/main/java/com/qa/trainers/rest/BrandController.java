package com.qa.trainers.rest;

import com.qa.trainers.domain.Brand;
import com.qa.trainers.service.BrandService;
import com.qa.trainers.dto.BrandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getAllBrands")
    public ResponseEntity<List<BrandDTO>> getAllBrands(){
        return ResponseEntity.ok(this.brandService.seeAllBrands());
    } //Read functionality. See all brands

    @PostMapping("/addBrand")
    public ResponseEntity<BrandDTO> addBrand(@RequestBody Brand brand){
        return new ResponseEntity<>(this.brandService.addBrand(brand), HttpStatus.CREATED);
    } //add (create) functionality. Line 30 - explicit type argument, can be replaced with <>

    @DeleteMapping("/deleteBrand/{brandId}")
    public Boolean deleteBrand(@PathVariable Long brandId){ // Delete functionality
        return this.brandService.deleteBrandById(brandId);
    }//delete functionality

    @GetMapping("/getBrandById/{brandId}")
    public ResponseEntity<BrandDTO> getBrandById(@PathVariable Long brandId){
        return ResponseEntity.ok(this.brandService.findBrandById(brandId));
    } //get brand by ID

    @GetMapping("/getBrandByName/{brandName}")
    public ResponseEntity<BrandDTO> getBrandByName(@PathVariable("brandName") String brandName){
        return ResponseEntity.ok(this.brandService.findByBrandName(brandName));
    } // get brand by name. spaces in URLs replaced by '+' or '%20'

    @PutMapping("/updateBrand/{brandId}")
    public ResponseEntity<BrandDTO> updateBrand(@PathVariable Long brandId, @RequestBody Brand brand){
        return ResponseEntity.ok(this.brandService.updateBrand(brandId, brand));
    }

}