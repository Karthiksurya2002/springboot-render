package com.hospital.smarthospitalmanagementportal.security.service;

import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.BookAppointment;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.service.BookAppointmentService;
import com.hospital.smarthospitalmanagementportal.security.model.User;
import com.hospital.smarthospitalmanagementportal.security.model.dto.LoginRequest;
import com.hospital.smarthospitalmanagementportal.security.model.dto.RegisterUser;
import com.hospital.smarthospitalmanagementportal.security.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private BookAppointmentService bookAppointmentService;

//    @Autowired
//    private BookAppointment bookAppointment;
//
    public void postUserDetailsData(RegisterUser user){
        User newUser = new User();
        if (user.getFirstName() == null ) {
            throw new IllegalArgumentException("First name is required");
        }
        if (String.valueOf(user.getMobileNo()).length() != 10) {
            throw new IllegalArgumentException("Mobile number must be 10 digits");
        }
//        if (userDetailsRepository.findByMobileNo(user.getMobileNo())) {
//            throw new IllegalArgumentException("Mobile number already registered");
//        }
        if(user.getPassword()==null || user.getPassword().length() < 6){
            throw new IllegalArgumentException("Password must be at least more then 6 characters");
        }
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setMobileNo(user.getMobileNo());
        newUser.setAddress(user.getAddress());
        newUser.setPassword(user.getPassword());
        newUser.setUserName(user.getUserName());
        userDetailsRepository.save(newUser);
    }

    public List<User> getUserData() {
        return  userDetailsRepository.findAll();
    }

    public Long getLoginData(LoginRequest loginUser) {

//        if (loginUser.getUserName() == null ) {
//            throw new IllegalArgumentException("User name is required");
//        }
//
//        if (loginUser.getPassword() == null || loginUser.getPassword().length() <=7) {
//            throw new IllegalArgumentException("Password must be at least 8 characters");
//        }

//        User user = userDetailsRepository.findByuserName(loginUser.getUserName());
//        BookAppointment bookAppointment = bookAppointmentService.findByAdUsername(loginUser.getUserName());


//        if (!user.getPassword().equals(loginUser.getPassword())) {
//            throw new SecurityException("Invalid credentials");
//        }
        User user = userDetailsRepository.findByuserName(loginUser.getUserName());

        if (user != null && user.getId() != null) {
            if (!user.getPassword().equals(loginUser.getPassword())) {
            throw new SecurityException("Invalid credentials");
        }
            return user.getId();
        }

        BookAppointment bookAppointment =
                bookAppointmentService.findByAdUsername(loginUser.getUserName());
        if(bookAppointment != null && bookAppointment.getId()!= null){
            if(!bookAppointment.getAdConfirmPassword().equals(loginUser.getPassword())){
                throw new SecurityException("Invalid credentials");
            }
            return bookAppointment != null ? bookAppointment.getId() : null;
        }

        return null;
    }

    public String getCheckRole(User newUser) {
        String role = " ";
        if (newUser != null) {
            User user = userDetailsRepository.findByuserName(newUser.getUserName());
            if(user!=null){
                 role =  user.getRole();
            }
                if (role.equalsIgnoreCase("Admin")){
                    return "Admin";
                }

                if (role.equalsIgnoreCase("User")) {
                    return "User";
                }
                String doctorRole = bookAppointmentService.checkRoleBa(newUser.getUserName());
                if(doctorRole!= null){
                    if(doctorRole.equalsIgnoreCase("DoctorLoginDetails")){
                        return "Doctor";
                    }
            }
        }

        return "No role is found";

    }

    public Optional<User> getUserLoggedInDetails(Long id) {
        Optional<User> user = userDetailsRepository.findById(id);
        return user;
    }
}
