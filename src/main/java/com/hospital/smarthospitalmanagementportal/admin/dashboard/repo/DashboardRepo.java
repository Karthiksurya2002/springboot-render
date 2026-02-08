package com.hospital.smarthospitalmanagementportal.admin.dashboard.repo;

import com.hospital.smarthospitalmanagementportal.admin.dashboard.model.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashboardRepo extends JpaRepository<Dashboard ,Long> {
    Dashboard findTopByTypeOrderByIdDesc(String type);
    //Dashboard findTopByFacilitiesNameContainingOrderByIdDesc(String value);


}
