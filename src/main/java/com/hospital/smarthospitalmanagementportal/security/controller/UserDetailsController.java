package com.hospital.smarthospitalmanagementportal.security.controller;

import com.hospital.smarthospitalmanagementportal.TwilioSmsService;
import com.hospital.smarthospitalmanagementportal.common.ApiResponse;
import com.hospital.smarthospitalmanagementportal.security.model.User;
import com.hospital.smarthospitalmanagementportal.security.model.dto.LoginRequest;
import com.hospital.smarthospitalmanagementportal.security.model.dto.RegisterUser;
import com.hospital.smarthospitalmanagementportal.security.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value="/shmp")  //Smart Hospital Management Portal
public class UserDetailsController {

    TwilioSmsService sms;
    @Autowired
    public UserDetailsController(TwilioSmsService sms) {
        this.sms = sms;
    }

    @Autowired
    private UserDetailsService userDetailsService;
    @GetMapping("/getUser")
    private ResponseEntity<?> getUser(){
        List<User> listUser = userDetailsService.getUserData();
        return ResponseEntity .ok(listUser);
    }

    @PostMapping(value="/register")
    private ResponseEntity<?> postUserDetails(@RequestBody RegisterUser user){

        if(user != null){
            userDetailsService.postUserDetailsData(user);
            ApiResponse<?> response = new ApiResponse<>();
            response.setMessage("User Successfully Created.");
            response.setData(null);
            response.setStatus(200);
            return ResponseEntity.ok(response);
        }else{
            ApiResponse<?> response = new ApiResponse<>();
            response.setMessage("In Valid User.");
            response.setData(null);
            response.setStatus(400);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> getLogin(@RequestBody LoginRequest loginUser){
        Long id =userDetailsService.getLoginData(loginUser);
        ApiResponse<Long> response = new ApiResponse<>();
        response.setMessage("Success");
        response.setData(id);
        response.setStatus(200);
//        sms.send( "Logged in successfully.");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("/checkrole")
    public ResponseEntity<?> getRole(@RequestBody User user){
       String value = userDetailsService.getCheckRole(user);
        ApiResponse<String> response = new ApiResponse<>();
        response.setMessage("Success");
        response.setData(value);
        response.setStatus(200);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping(value="/getUserDetails")
    public ResponseEntity<?> getUserLoggedInDetails(@RequestParam("id") Long id){
        Optional<User> user = userDetailsService.getUserLoggedInDetails(id);
        ApiResponse< Optional<User>> response = new ApiResponse<>();
        response.setMessage(null);
        response.setData(user);
        response.setStatus(200);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
