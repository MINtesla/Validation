package com.URLvalidation.Validation.validator.PhoneMessage;

import com.URLvalidation.Validation.validator.Service.ResultService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class SmsService {


    @Value("${TWILIO_ACCOUNT_SID}")
    String ACCOUNT_SID;

    @Value("${TWILIO_AUTH_TOKEN}")
    String AUTH_TOKEN;
    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
    String OUTGOING_SMS_NUMBER;

    Logger logger = LoggerFactory.getLogger(SmsService.class);

    @PostConstruct
    private void setup()
    {
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);

    }

    @Async
    public CompletableFuture<String> sendSms(String msisdn, String subject) {
        try {
            String phoneNo = "+91" + msisdn;
            Message message = Message.creator(
                    new PhoneNumber(msisdn),
                    new PhoneNumber(OUTGOING_SMS_NUMBER),
                    subject).create();
            logger.info("sending the Message to given msisdn with thread : " + Thread.currentThread().getName());
            return CompletableFuture.completedFuture(message.getStatus().toString());
        }catch (Exception e){
            logger.error("Not able to send Message with thread :" + Thread.currentThread().getName());
        }
        return CompletableFuture.completedFuture("MSG NOT SEND");
    }
}
