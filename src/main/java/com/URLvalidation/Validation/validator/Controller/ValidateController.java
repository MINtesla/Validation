package com.URLvalidation.Validation.validator.Controller;

import com.URLvalidation.Validation.validator.Model.Result;
import com.URLvalidation.Validation.validator.Model.Validate;
import com.URLvalidation.Validation.validator.Service.BillService;
import com.URLvalidation.Validation.validator.Service.ValidateService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ValidateController {


    private final BillService billService;
    private final ValidateService validateService;

    @Autowired
    public ValidateController(BillService billService, ValidateService validateService) {
        this.billService = billService;
        this.validateService = validateService;
    }

    @GetMapping
    public List<Validate> getValidator() {
        return validateService.getValidator();
    }


    //    @RequestMapping(value = "/urlvali", method = RequestMethod.POST , produces = MediaType.TEXT_HTML_VALUE)
//    public String requestValidation(@RequestParam(value = "msisdn") String msisdn,
//                                    @RequestParam(value = "emailid") String emailid) {
//        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
//                "<body>\n" +"<h1>\n"+ validateService.requestValidation(msisdn, emailid) +"\n</h1>\n"+ "</body>\n" + "</html>";
//    }

    //        Bill bill = billService.findBillByMsisdn(Math.toIntExact((Long) Long.parseLong(msisdn)));
//        if (bill != null) {
//            System.out.println(bill.getBillPrice());
//            System.out.println(bill.getName());
//        } else {
//            System.out.println("Data does not exist.");
//        }
//        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
//                "<body>\n" + "<h1>\n" + validateService.requestValidation(msisdn, emailid).get()
//                + "\n</h1>\n" + "</body>\n" + "</html>";
    @GetMapping(value="/urlvali")
    public List<Result> requestValidation(@RequestParam String msisdn, @RequestParam String emailid) throws ExecutionException, InterruptedException {

        List<Result> jsonResponse = validateService.requestValidation(msisdn, emailid).get();
        for (int i = 0; i < jsonResponse.size(); i++) {


            System.out.println(jsonResponse.get(i));
        }


        return jsonResponse;
    }

}
