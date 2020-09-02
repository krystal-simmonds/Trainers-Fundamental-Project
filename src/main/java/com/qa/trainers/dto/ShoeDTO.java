package com.qa.trainers.dto;

import com.qa.trainers.domain.Shoe;

public class ShoeDTO {

    private Long shoeId;
    private String shoeName;
    private String shoeColour;
    private String brandName;
    private Long shoeSize;

    public ShoeDTO(){
    }

    public ShoeDTO(String shoeName, String shoeColour, String brandName, Long shoeSize){
        this.shoeName = shoeName;
        this.shoeColour = shoeColour;
        this.brandName = brandName;
        this.shoeSize = shoeSize;
    }

    public Long getShoeId() {
        return shoeId;
    }

    public void setShoeId(Long shoeId) {
        this.shoeId = shoeId;
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public String getShoeColour() {
        return shoeColour;
    }

    public void setShoeColour(String shoeColour) {
        this.shoeColour = shoeColour;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(Long shoeSize) {
        this.shoeSize = shoeSize;
    }
}
