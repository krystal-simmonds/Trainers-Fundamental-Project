package com.qa.trainers.service;

import com.qa.trainers.domain.Brand;
import com.qa.trainers.exceptions.BrandNotFoundException;
import com.qa.trainers.repo.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepo;

    @Autowired
    public BrandService(BrandRepository brandRepo) {
        this.brandRepo = brandRepo;
    }

    public List<Brand> seeAllBrands(){
        return this.brandRepo.findAll();
    } //show all brands

    public Brand addBrand(Brand brand){
        return this.brandRepo.save(brand);
    } // add brand

    public Brand findBrandById(Long brandId){
        return this.brandRepo.findById(brandId).orElseThrow(BrandNotFoundException::new); // find brand by ID
    }

    public Brand updateBrand(Long brandId, Brand brand){ // update brand name
        Brand brandUpdate = findBrandById(brandId);
        brandUpdate.setBrandName(brand.getBrandName());
        return this.brandRepo.save(brandUpdate);
    }

    public Boolean deleteBrandById(Long brandId){
        if(!this.brandRepo.existsById(brandId)){
            throw new BrandNotFoundException();
        }
        this.brandRepo.deleteById(brandId);
        return this.brandRepo.existsById(brandId); // delete brand
    }

}
