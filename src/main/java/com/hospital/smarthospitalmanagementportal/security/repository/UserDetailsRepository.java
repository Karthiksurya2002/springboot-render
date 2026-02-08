package com.hospital.smarthospitalmanagementportal.security.repository;

import com.hospital.smarthospitalmanagementportal.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {
    boolean findByMobileNo(long mobileNo);
    User findByuserName(String userName);
    boolean existsByUserName(String name);
}
