package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.repo;

import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model.PatientCareServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCareServicesRepo extends JpaRepository<PatientCareServices , Long> {
    PatientCareServices findTopByOrderByIdDesc();
    PatientCareServices findTopByUsageOrderByIdDesc(String usage);
}
