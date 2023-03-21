package com.URLvalidation.Validation.validator.configration;


import com.URLvalidation.Validation.validator.Model.Bill;
import com.URLvalidation.Validation.validator.Repossitory.BillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BillConfig {

    @Bean
    CommandLineRunner lineRunner
            (BillRepository billRepository){
        return args -> {
            Bill v1 = new Bill(
                   2000d,
                    7011928653l,
                    "Ashutosh Singh"
            );
            Bill v2 = new Bill(
                    3000d,
                    9968855233l,
                    "Ashutosh Singh"
            );

            billRepository.saveAll(
                    List.of(v1,v2)
            );

        };
    }
}
