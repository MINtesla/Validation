package com.URLvalidation.Validation.validator.Repossitory;

import com.URLvalidation.Validation.validator.Model.Validate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ValidateRepository
        extends JpaRepository<Validate,String> {

    @Query("Select v from Validate v where v.param_name=?1")
    Optional<Validate> findValidateByParam_name(String param_name);
}
