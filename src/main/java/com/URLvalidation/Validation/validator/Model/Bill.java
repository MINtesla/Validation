package com.URLvalidation.Validation.validator.Model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Entity
@Table(name = "bill")
public class Bill {

    @Id
    private Long msisdn;
    private Double billPrice;

    private String name;

    public Bill(){

    }

    public Bill( Double billPrice, Long msisdn, String name) {
        this.billPrice = billPrice;
        this.msisdn = msisdn;
        this.name = name;
    }

    public Long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Long msisdn) {
        this.msisdn = msisdn;
    }

    public Double getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(Double billPrice) {
        this.billPrice = billPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
