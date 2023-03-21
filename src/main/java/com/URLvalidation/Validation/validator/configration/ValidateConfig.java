package com.URLvalidation.Validation.validator.configration;

import com.URLvalidation.Validation.validator.Model.Validate;
import com.URLvalidation.Validation.validator.Repossitory.ValidateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ValidateConfig {

    @Bean
    CommandLineRunner commandLineRunner
            (ValidateRepository repository){
        return args -> {
            Validate v1 = new Validate(
                    "msisdn",
                    1,
                    "Long",
                    8,
                    20,
                    null
            );
            Validate v2 = new Validate(
                    "emailid",
                    1,
                    "String",
                    null,
                    null,
//                    "^(.+)@(\\\\S+)$"
                    null
            );

            repository.saveAll(
                    List.of(v1,v2)
            );

        };
    }
}
