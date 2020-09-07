package com.qa.trainers.domain;

import javax.persistence.*;

@Entity
public class Shoe {
    @Id
    @GeneratedValue
    private Long shoeId;

    @Column(unique = true, nullable = false)
    private String shoeName;

    @Column
    private String brandName;

    @Column
    private Long shoeSize;

    @Column
    private String shoeColour;

    @ManyToOne(targetEntity = Brand.class)
    private Brand brand;

    public Shoe(){
    }

    public Shoe(String shoeName, String brandName, Long shoeSize, String shoeColour) {
        this.shoeName = shoeName;
        this.brandName = brandName;
        this.shoeSize = shoeSize;
        this.shoeColour = shoeColour;
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

    public String getShoeColour() {
        return shoeColour;
    }
    public void setShoeColour(String shoeColour) {
        this.shoeColour = shoeColour;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

}
