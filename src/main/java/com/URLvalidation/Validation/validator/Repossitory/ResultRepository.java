package com.URLvalidation.Validation.validator.Repossitory;

import com.URLvalidation.Validation.validator.Model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultRepository extends
        JpaRepository<Result,String> {
//
    @Query("Select r from Result r where r.resp_key=?1")
    Optional<Result>  findResultByResp_key(String resp_key);
}
