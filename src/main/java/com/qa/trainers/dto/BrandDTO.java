package com.qa.trainers.dto;

import java.util.ArrayList;
import java.util.List;

public class BrandDTO {

    private Long brandId;
    private String brandName;
    private List<ShoeDTO> shoes = new ArrayList<>();

    public BrandDTO(){
    }

    public BrandDTO(String brandName){
        super();
        this.brandName = brandName;
    }

    public Long getBrandId(){
        return brandId;
    }

    public void setBrandId(Long brandId){
        this.brandId = brandId;
    }

    public void setBrandName(String brandName){
        this.brandName = brandName;
    }

    public List<ShoeDTO> getShoes() {
        return shoes;
    }

    public void setShoes(List<ShoeDTO> shoes){
        this.shoes = shoes;
    }

}
