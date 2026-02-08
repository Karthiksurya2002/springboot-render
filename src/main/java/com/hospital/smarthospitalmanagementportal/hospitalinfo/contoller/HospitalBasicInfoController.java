package com.hospital.smarthospitalmanagementportal.hospitalinfo.contoller;

import com.hospital.smarthospitalmanagementportal.common.ApiResponse;
import com.hospital.smarthospitalmanagementportal.hospitalinfo.model.HospitalBasicInfo;
import com.hospital.smarthospitalmanagementportal.hospitalinfo.service.HospitalBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/shmp/public")
public class HospitalBasicInfoController {
    @Autowired
    HospitalBasicInfoService hospitalBasicInfoService;
    @GetMapping(value="/info")
    public ResponseEntity<?> getInfo(){
        List infoList = hospitalBasicInfoService.getInfo();

      //  response.setMessage("User Successfully Created.");
        if(!infoList.isEmpty()) {
            ApiResponse<List<HospitalBasicInfo>> response = new ApiResponse<>();
            response.setData(infoList);
            response.setStatus(200);
            return ResponseEntity.ok(response);
        }
        else {
            ApiResponse<String> response = new ApiResponse<>();
            response.setData("No user data found");
            response.setStatus(200);
            return ResponseEntity.ok(response);
        }

    }
}
