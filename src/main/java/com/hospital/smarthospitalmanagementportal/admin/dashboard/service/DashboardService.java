package com.hospital.smarthospitalmanagementportal.admin.dashboard.service;

import com.hospital.smarthospitalmanagementportal.admin.dashboard.model.Dashboard;
import com.hospital.smarthospitalmanagementportal.admin.dashboard.model.dto.FacilitiesDetails;
import com.hospital.smarthospitalmanagementportal.admin.dashboard.repo.DashboardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DashboardService {
    @Autowired
    DashboardRepo dashboardRepo;
    public void setTileDashboard(Dashboard dashboard) {
        if(dashboard == null){
            throw new IllegalArgumentException("Please dont sumbit with empty data");
        }
        Dashboard newDashboard = new Dashboard();
        newDashboard.setTitle(dashboard.getTitle());
        newDashboard.setDescription(dashboard.getDescription());
        newDashboard.setButtonName(dashboard.getButtonName());
        newDashboard.setType("TileDashboard");
        dashboardRepo.save(newDashboard);
    }

    public List<Dashboard> getDashboardData() {
        return Collections.singletonList(dashboardRepo.findTopByTypeOrderByIdDesc("TileDashboard"));

    }

    public void addFacilitiesDeatils(FacilitiesDetails facilitiesDetails) {
         Dashboard details = new Dashboard();
        details.setFacilitiesDetails(
                Collections.singletonList(String.join(",", facilitiesDetails.getFacilitiesDetails()))
        );
        details.setButtonFacilitiesName(facilitiesDetails.getButtonName());
        details.setTitleFacilities(facilitiesDetails.getTitleFacilities());
        details.setType("facilitesDetails");
        dashboardRepo.save(details);
    }

    public Dashboard getFacilitiesDeatils() {

        Dashboard dashboard =
                dashboardRepo.findTopByTypeOrderByIdDesc("facilitesDetails");

        if (dashboard == null) {
            throw new RuntimeException("No facilities details found");
        }

        return dashboard;
    }


}
