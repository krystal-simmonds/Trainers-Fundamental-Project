package com.qa.trainers.service;

import com.qa.trainers.domain.Brand;
import com.qa.trainers.dto.BrandDTO;
import com.qa.trainers.exceptions.BrandNotFoundException;
import com.qa.trainers.repo.BrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepo;

    private final ModelMapper mapper;

    @Autowired
    public BrandService(BrandRepository brandRepo, ModelMapper mapper) {
        this.brandRepo = brandRepo;
        this.mapper = mapper;
    }

    private BrandDTO mapToDTO(Brand brand){
        return this.mapper.map(brand, BrandDTO.class);
    }

    public List<BrandDTO> seeAllBrands(){
        return this.brandRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    } //show (read) all brands

    public BrandDTO addBrand(Brand brand){
        return this.mapToDTO(this.brandRepo.save(brand));
    } // add (create) brand

    public BrandDTO findBrandById(Long brandId){
        return this.mapToDTO(brandRepo.findById(brandId).orElseThrow(BrandNotFoundException::new));
    } // find brand by ID

    public BrandDTO updateBrand(Long brandId, Brand brand){
        Brand brandUpdate = this.brandRepo.findById(brandId).orElseThrow(BrandNotFoundException::new);
        brandUpdate.setBrandName(brand.getBrandName());
        return this.mapToDTO(this.brandRepo.save(brandUpdate));
    }

    public Boolean deleteBrandById(Long brandId){
        if(!this.brandRepo.existsById(brandId)){
            throw new BrandNotFoundException();
        }
        this.brandRepo.deleteById(brandId);
        return this.brandRepo.existsById(brandId); // delete brand
    }

}
