package com.hospital.smarthospitalmanagementportal.hospitalinfo.repo;

import com.hospital.smarthospitalmanagementportal.hospitalinfo.model.HospitalBasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalBasicInfoRepo extends JpaRepository<HospitalBasicInfo,Long> {
}
