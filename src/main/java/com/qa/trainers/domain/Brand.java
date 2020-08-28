package com.qa.trainers.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand {

    @Id
    @GeneratedValue
    private Long brandId;

    @Column(unique = true, nullable = false)
    private String brandName;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private List<Shoe> shoes = new ArrayList<>();

    public Brand() {
    }

    public Brand(Long brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    public Long getBrandId() {
        return brandId;
    }
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Shoe> getShoes() {
        return shoes;
    }

    public void setShoes(List<Shoe> shoes) {
        this.shoes = shoes;
    }
}
