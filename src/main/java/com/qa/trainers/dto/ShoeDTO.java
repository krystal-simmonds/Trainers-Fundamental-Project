package com.qa.trainers.dto;

import com.qa.trainers.domain.Shoe;

public class ShoeDTO {

    private Long shoeId;
    private String shoeName;
    private String shoeColour;
    private Long shoeSize;

    public ShoeDTO(){
    }

    public ShoeDTO(String shoeName, String shoeColour, String brandName, Long shoeSize){
        this.shoeName = shoeName;
        this.shoeColour = shoeColour;
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

    public Long getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(Long shoeSize) {
        this.shoeSize = shoeSize;
    }
}
