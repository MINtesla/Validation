package com.URLvalidation.Validation.validator.Service;

import com.URLvalidation.Validation.validator.Model.Bill;
import com.URLvalidation.Validation.validator.Model.Result;
import com.URLvalidation.Validation.validator.Model.Validate;
import com.URLvalidation.Validation.validator.Repossitory.ResultRepository;
import com.URLvalidation.Validation.validator.Repossitory.ValidateRepository;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ValidateService {

    private final ValidateRepository validateRepository;
    private final MsgService msgService;
    private final ResultRepository resultRepository;
    private final BillService billService;

    private final ResultService resultService;

    Logger logger = LoggerFactory.getLogger(ValidateService.class);

    @Autowired
    public ValidateService(ValidateRepository validateRepository, MsgService msgService, ResultRepository resultRepository, BillService billService, ResultService resultService) {
        this.validateRepository = validateRepository;
        this.msgService = msgService;
        this.resultRepository = resultRepository;
        this.billService = billService;
        this.resultService = resultService;
    }
    public List<Validate> getValidator() {

        return validateRepository.findAll();
    }

    public static boolean isNumeric(String str) {

        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    public Integer validateEmailid(String emailid) {
        Optional<Validate> v1 =
                validateRepository.findValidateByParam_name("emailid");
        if (v1.get().getIs_mandatory() == 1) {
            if (emailid == null || emailid == "") {
                return 1;
            }
            if (v1.get().getDatatype() == "String") {

                if (v1.get().getMin_length() == 0 && v1.get().getMax_length() == 0) {

                } else if (v1.get().getMin_length() != null && v1.get().getMax_length() != null &&
                        v1.get().getMin_length() <= emailid.length()
                        && v1.get().getMax_length() >= emailid.length()) {

                } else {
                    return 2;
                }

            if (v1.get().getRegex() == null) {
                return 0;
            }
            if (emailid.matches(v1.get().getRegex())) {
                return 0;
            } else {
                return 4;
            }

    }else if (v1.get().getDatatype() == "Long") {
                long l = 0l;
                if (isNumeric(emailid)) {
                    if (v1.get().getMax_length() == null && v1.get().getMax_length() == null) {

                    } else if (v1.get().getMin_length() != null && v1.get().getMin_length() != null &&
                            v1.get().getMin_length() >= emailid.length()
                            && v1.get().getMax_length() <= emailid.length()) {
                        l = Long.parseLong(emailid);
                    } else {
                        return 2;
                    }
                } else {
                    return 2;
                }
                if (v1.get().getRegex() == null) {
                    return 0;
                }
                if (emailid.matches(v1.get().getRegex())) {
                    return 0;
                } else {
                    return 3;
                }

            } else if (v1.get().getDatatype() == "Integer") {
                Integer i = 0;
                if (isNumeric(emailid)) {
                    if (v1.get().getMax_length() == null && v1.get().getMax_length() == null) {

                    } else if (v1.get().getMin_length() != null && v1.get().getMin_length() != null &&
                            v1.get().getMin_length() >= emailid.length()
                            && v1.get().getMax_length() <= emailid.length()) {
                        i = Integer.parseInt(emailid);
                    } else {
                        return 2;
                    }
                } else {
                    return 2;
                }
                if (v1.get().getRegex() == null) {
                    return 0;
                }
                if (emailid.matches(v1.get().getRegex())) {
                    return 0;
                } else {
                    return 3;
                }
            }
        }


        return 0;

    }
    public Integer validateMsisdn(String msisdn){
        Optional<Validate> v1 =


                validateRepository.findValidateByParam_name("msisdn");
        System.out.println(v1.get().getRegex());
        System.out.println(v1.get().getIs_mandatory());
        System.out.println(v1.get().getDatatype());
        System.out.println(v1.get().getMax_length());
        System.out.println(v1.get().getMin_length());

        if(v1.get().getIs_mandatory()==1) {
            if (msisdn == null || msisdn=="") {
                return 1;
            }
            if (v1.get().getDatatype().equals("String") ){
                if (v1.get().getMax_length() == null && v1.get().getMax_length() == null) {

                } else if (v1.get().getMin_length() != null && v1.get().getMin_length() != null &&
                        v1.get().getMin_length() >= msisdn.length()
                        && v1.get().getMax_length() <= msisdn.length()) {
                    // nothing to execute here
                } else {
                    return 2;
                }
                if(v1.get().getRegex()==null){
                    return 0;
                }
                if(msisdn.matches(v1.get().getRegex())){
                    return 0;
                }else{
                    return 3;
                }

            } else if (v1.get().getDatatype().equals( "Long")) {


                if (isNumeric(msisdn)) {


                    if (v1.get().getMax_length() == null && v1.get().getMax_length() == null) {

                    } else if (v1.get().getMin_length() != null && v1.get().getMin_length() != null &&
                            v1.get().getMin_length() <= msisdn.length()
                            && v1.get().getMax_length() >= msisdn.length()) {

                        try {
                            long l = Long.parseLong(msisdn);
                        } catch (NumberFormatException nfe) {
                            return 3;
                        }

                    } else {
                       return 2;
                    }
                } else {
                    return 3;
                }
                if(v1.get().getRegex()==null){
                    return 0;
                }
                if(msisdn.matches(v1.get().getRegex())){
                    return 0;
                }else{
                    return 4;
                }

            } else if (v1.get().getDatatype().equals("Integer")) {
                if (isNumeric(msisdn)) {
                    if (v1.get().getMax_length() == null && v1.get().getMax_length() == null) {

                    } else if (v1.get().getMin_length() != null && v1.get().getMin_length() != null &&
                            v1.get().getMin_length() >= msisdn.length()
                            && v1.get().getMax_length() <= msisdn.length()) {
                        try {
                            Integer i = Integer.parseInt(msisdn);
                        } catch (NumberFormatException nfe) {
                            return 3;
                        }
                    } else {
                        return 2;
                    }
                } else {
                    return 2;
                }
                if(v1.get().getRegex()==null){
                    return 0;
                }
                if(msisdn.matches(v1.get().getRegex())){
                    return 0;
                }else{
                    return 4;
                }
            }
        }

        return 0;

    }

    @Async
    public CompletableFuture<List<Result>> requestValidation(String msisdn, String emailid) throws ExecutionException, InterruptedException {
        Result result = new Result();
//        Result ans1 = null, ans2 = null;
        CompletableFuture<Result> ans1=null,ans2 = null;
        Integer resultcode1 = validateMsisdn(msisdn);
        Integer resultcode2 = validateEmailid(emailid);
        System.out.println(resultcode1);
        System.out.println(resultcode2);
        switch (resultcode1) {
            case 0:

                ans1 = resultService.getResult("SUCCESS");

                break;
            case 1:
                ans1 = resultService.getResult("MISSING_PARAM");
                ans1.get().setNewResult("MSISDN");
                break;
            case 2:
                ans1 = resultService.getResult("INVALID_DATATYPE");
                ans1.get().setNewResult("MSISDN");
                break;
            case 3:
                ans1 = resultService.getResult("OUT_OF_LENGTH");
                ans1.get().setNewResult("MSISDN");
                break;
            case 4:
                ans1 = resultService.getResult("INVALID_FORMAT");
                ans1.get().setNewResult("MSISDN");
                break;

        }


        switch (resultcode2) {
            case 0:
                ans2 = resultService.getResult("SUCCESS");
                break;
            case 1:
                ans2 = resultService.getResult("MISSING_PARAM");
                ans2.get().setNewResult("EMAILID");
                break;
            case 2:
                ans2 = resultService.getResult("INVALID_DATATYPE");
                ans2.get().setNewResult("EMAILID");
                break;
            case 3:
                ans2 = resultService.getResult("OUT_OF_LENGTH");
                ans2.get().setNewResult("EMAILID");
                break;
            case 4:
                ans2 = resultService.getResult("INVALID_FORMAT");
                ans2.get().setNewResult("EMAILID");
                break;

        }
        logger.info("Validation Done for the URL with thread : "+Thread.currentThread().getName());
        // bill call
        if(resultcode1==0 && resultcode2==0) {
            long l = Long.parseLong(msisdn);
            Bill bill = billService.findBillByMsisdn(l);
            if(bill==null){
                ans1 = resultService.getResult("NOT_AVAILABLE");
                String sub= "Sorry, Your request could not be processed.";
                return CompletableFuture.completedFuture(List.of(ans1.get()));
            }else{

                System.out.println(msgService.sendEmail(emailid,
                        ans1.get().getResult(),
                        "MAIL SEND DONE"));
                msgService.sendSms(msisdn,"Sms to you ");
            }



        }



        System.out.println(ans1.get().getResult() + " " + ans2.get().getResult());

        return  CompletableFuture.completedFuture(List.of(ans1.get(),ans2.get()));

    }

}
