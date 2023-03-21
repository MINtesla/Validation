package com.URLvalidation.Validation.validator.Service;

import com.URLvalidation.Validation.validator.PhoneMessage.SmsRequest;
import com.URLvalidation.Validation.validator.PhoneMessage.SmsService;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class MsgService {


    @Autowired
    private final SmsService smsService;
    @Autowired
    private JavaMailSender mailSender;


    Logger logger = LoggerFactory.getLogger(MsgService.class);

    public MsgService(SmsService smsService) {
        this.smsService=smsService;
    }


    public void sendSms(String msisdn, String subject) {
        smsService.sendSms(msisdn,subject);
    }


    @Async
    public CompletableFuture<String> sendEmail(String emailid, String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("udayaashu1502@gmail.com");
        message.setTo(emailid);
        message.setText(body);
        message.setSubject(subject);
        logger.info("sending the Mail to given emailId with thread : "+Thread.currentThread().getName());
        mailSender.send(message);
        return CompletableFuture.completedFuture("mail send done");
    }
}
