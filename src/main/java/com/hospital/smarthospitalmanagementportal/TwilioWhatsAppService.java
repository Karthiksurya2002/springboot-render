//package com.hospital.smarthospitalmanagementportal;
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TwilioWhatsAppService {
//
//    @Value("${twilio.account-sid}")
//    private String accountSid;
//
//    @Value("${twilio.auth-token}")
//    private String authToken;
//
//    @Value("${twilio.whatsapp-from}")
//    private String from;
//
//    @PostConstruct
//    public void init() {
//        Twilio.init(accountSid, authToken);
//    }
//
//    public void sendMessage(String to, String message) {
//        Message msg = Message.creator(
//                new PhoneNumber("whatsapp:+91" + to),
//                new PhoneNumber(from),
//                message
//        ).create();
//        System.out.println("TWILIO MESSAGE SID = " + msg.getSid());
//    }
//}
