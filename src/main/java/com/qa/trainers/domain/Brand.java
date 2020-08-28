package com.qa.trainers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Brand {

    @Id
    @GeneratedValue
    private Long brandId;

    @Column(unique = true, nullable = false)
    private String brandName;

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
}
