package com.hospital.smarthospitalmanagementportal.admin.dashboard.controller;

import com.hospital.smarthospitalmanagementportal.admin.dashboard.model.Dashboard;
import com.hospital.smarthospitalmanagementportal.admin.dashboard.model.dto.FacilitiesDetails;
import com.hospital.smarthospitalmanagementportal.admin.dashboard.service.DashboardService;
import com.hospital.smarthospitalmanagementportal.common.ApiResponse;
import com.hospital.smarthospitalmanagementportal.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shmp/dashboard")
public class DashboardController {
    @Autowired
    DashboardService dashboardService;
    @PostMapping("/setTitle")
    ApiResponse<?> setTitle (@RequestBody Dashboard dashboard){
        dashboardService.setTileDashboard(dashboard);
        ApiResponse<String>response = new ApiResponse<>();
        response.setStatus(201);
        response.setData(null);
        response.setMessage("Dashboard Information Saved Successfully");
        return response;
    }
    @GetMapping("/getTitle")
    ResponseEntity<?> getDashboardData(){
        List<Dashboard> list = dashboardService.getDashboardData();
        ApiResponse<List>response = new ApiResponse<>();
        response.setStatus(200);
        response.setMessage("null");
        return ResponseEntity .ok(list);
    }
    @PostMapping("/editFacilitiesDeatils")
    ResponseEntity<?> addFacilitiesDeatils(@RequestBody FacilitiesDetails facilitiesDetails){
        dashboardService.addFacilitiesDeatils(facilitiesDetails);
        ApiResponse<String>response = new ApiResponse<>();
        response.setStatus(201);
        response.setMessage("Updated Successfully.");
        return ResponseEntity .ok(response);
    }
    @GetMapping(value ="/getFacilitiesDeatils")
    ResponseEntity<?> getFacilitiesDeatils(){
        Dashboard dashboard = dashboardService.getFacilitiesDeatils();
        ApiResponse<Dashboard>response = new ApiResponse<>();
        response.setStatus(200);
        response.setMessage("null");
        response.setData(dashboard);
        return ResponseEntity .ok(response);
    }
}
