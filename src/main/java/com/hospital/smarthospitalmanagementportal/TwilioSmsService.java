package com.hospital.smarthospitalmanagementportal;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwilioSmsService {

//    @Value("${twilio.accountSid}")
//    private String accountSid;
//
//    @Value("${twilio.authToken}")
//    private String authToken;
//
//    @Value("${twilio.smsFrom}")
//    private String smsFrom;
//
//    @PostConstruct
//    public void init() {
//        Twilio.init(accountSid, authToken);
//    }

    public void send( String text) {
//        Message.creator(
//                new PhoneNumber("+91" + "9080564314"),
////                new PhoneNumber(smsFrom),
////                text
//        ).create();
    }
}
