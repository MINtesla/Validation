package com.URLvalidation.Validation.validator.Repossitory;

import com.URLvalidation.Validation.validator.Model.Bill;
import com.URLvalidation.Validation.validator.Model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    @Query("Select b from Bill b where b.msisdn=?1")
    Bill findByMsisdn(Long msisdn);
}
