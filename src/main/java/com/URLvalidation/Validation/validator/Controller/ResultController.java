package com.URLvalidation.Validation.validator.Controller;


import com.URLvalidation.Validation.validator.Service.ValidateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ResultController {


    private final ValidateService validateService;
    public ResultController(ValidateService validateService) {

        this.validateService = validateService;
    }


}
