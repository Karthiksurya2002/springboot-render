package com.hospital.smarthospitalmanagementportal;

import com.hospital.smarthospitalmanagementportal.security.model.User;
import com.hospital.smarthospitalmanagementportal.security.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SmartHospitalManagementPortalApplication {

	public static void main(String[] args) {

        SpringApplication.run(SmartHospitalManagementPortalApplication.class, args);
	}
    @Bean
    CommandLineRunner createDefaultAdmin(
            UserDetailsRepository userDetailsRepository) {

        return args -> {

            if (!userDetailsRepository.existsByUserName("shmpadmin")) {
                User user = new User();
                user.setRole("ADMIN");
                user.setUserName("shmpadmin");
                user.setPassword("shmpadmin");
                user.setFirstName("Karthik");
                user.setLastName("Surya");
                user.setEmailId("admin@email.com");
                user.setMobileNo(9080564314L);
                user.setAddress("227 Govindhapuram");
                user.setActive(true);
                userDetailsRepository.save(user);
            }
        };
    }
}
