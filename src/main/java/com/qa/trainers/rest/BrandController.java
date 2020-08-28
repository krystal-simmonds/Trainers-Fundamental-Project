package com.qa.trainers.rest;

import com.qa.trainers.domain.Brand;
import com.qa.trainers.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getAllBrands")
    public List<Brand> getAllBrands(){
        return this.brandService.seeAllBrands(); //Read functionality
    }

    @PostMapping("/addBrand")
    public Brand addBrand(@RequestBody Brand brand){ // Create/add functionality
        return this.brandService.addBrand(brand);
    }

    @DeleteMapping("/delete/{brandId}")
    public Boolean deleteBrand(@PathVariable Long brandId){ // Delete functionality
        return this.brandService.deleteBrandById(brandId);
    }

    @GetMapping("/getBrandById/{brandId}")
    public Brand getBrandById(@PathVariable Long brandId){
        return this.brandService.findBrandById(brandId);
    }

    @PutMapping("/updateBrand/{brandId}")
    public Brand updateBrand(@PathVariable Long brandId, @RequestBody Brand brand){ // Update functionality
        return this.brandService.updateBrand(brandId, brand);
    }

}