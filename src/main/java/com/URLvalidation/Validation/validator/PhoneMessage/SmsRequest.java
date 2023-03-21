package com.URLvalidation.Validation.validator.PhoneMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.twilio.twiml.voice.Sms;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.lang.Nullable;




@Data
public class SmsRequest {


    private  String phoneNumber; // destination
    private  String message;
    public SmsRequest(){

    }

    public SmsRequest( String phoneNumber,
                       String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber= ..." + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}