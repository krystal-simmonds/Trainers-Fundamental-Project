package com.qa.trainers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Shoe {
    @Id
    @GeneratedValue
    private Integer shoeId;

    @Column(unique = true, nullable = false)
    private String shoeName;

    @Column
    private String shoeBrand;

    @Column
    private Byte shoeSize;

    @Column
    private String shoeColour;

    public Shoe(){
    }

    public Shoe(String shoeName, String shoeBrand, Byte shoeSize, String shoeColour) {
        this.shoeName = shoeName;
        this.shoeBrand = shoeBrand;
        this.shoeSize = shoeSize;
        this.shoeColour = shoeColour;
    }

    public Integer getShoeId() {
        return shoeId;
    }
    public void setShoeId(Integer shoeId) {
        this.shoeId = shoeId;
    }

    public String getShoeName() {
        return shoeName;
    }
    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public String getShoeBrand() {
        return shoeBrand;
    }
    public void setShoeBrand(String shoeBrand) {
        this.shoeBrand = shoeBrand;
    }

    public Byte getShoeSize() {
        return shoeSize;
    }
    public void setShoeSize(Byte shoeSize) {
        this.shoeSize = shoeSize;
    }

    public String getShoeColour() {
        return shoeColour;
    }
    public void setShoeColour(String shoeColour) {
        this.shoeColour = shoeColour;
    }
}
