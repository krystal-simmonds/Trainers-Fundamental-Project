package com.qa.trainers.rest;

import com.qa.trainers.domain.Brand;
import com.qa.trainers.service.BrandService;
import com.qa.trainers.dto.BrandDTO;
import com.sun.org.apache.xpath.internal.operations.Bool;
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

    @CrossOrigin(origins = "*")
    @GetMapping("/getAllBrands")
    public ResponseEntity<List<BrandDTO>> getAllBrands(){
        return ResponseEntity.ok(this.brandService.seeAllBrands());
    } //Read functionality. See all brands

    @CrossOrigin(origins = "*")
    @PostMapping("/addBrand")
    public ResponseEntity<BrandDTO> addBrand(@RequestBody Brand brand){
        return new ResponseEntity<>(this.brandService.addBrand(brand), HttpStatus.CREATED);
    } //add (create) functionality. Line 30 - explicit type argument, can be replaced with <>

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteBrand/{brandId}")
    public Boolean deleteBrand(@PathVariable Long brandId){ // Delete functionality
        return this.brandService.deleteBrandById(brandId);
    }//delete functionality

    @CrossOrigin(origins = "*")
    @GetMapping("/getBrandById/{brandId}")
    public ResponseEntity<BrandDTO> getBrandById(@PathVariable Long brandId){
        return ResponseEntity.ok(this.brandService.findBrandById(brandId));
    } //get brand by ID


    /*@CrossOrigin(origins = "*")
    @GetMapping("/getBrandByName/{brandName}")
    public ResponseEntity<BrandDTO> getBrandByName(@PathVariable("brandName") String brandName){
        return ResponseEntity.ok(this.brandService.findByBrandName(brandName));
    } // get brand by name. spaces in URLs replaced by '+' or '%20'*/

    @CrossOrigin(origins = "*")
    @PutMapping("/updateBrand/{brandId}")
    public ResponseEntity<BrandDTO> updateBrand(@PathVariable Long brandId, @RequestBody Brand brand){
        return ResponseEntity.ok(this.brandService.updateBrand(brandId, brand));
    }

}