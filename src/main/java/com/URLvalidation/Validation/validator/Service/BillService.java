package com.URLvalidation.Validation.validator.Service;

import com.URLvalidation.Validation.validator.Model.Bill;
import com.URLvalidation.Validation.validator.Repossitory.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;

    public Bill findBillByMsisdn(Long msisdn) {
        return billRepository.findByMsisdn(msisdn);
    }
}