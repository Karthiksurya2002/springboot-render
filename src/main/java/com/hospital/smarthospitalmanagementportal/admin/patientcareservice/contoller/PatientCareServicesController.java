package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.contoller;

import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model.PatientCareServices;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model.dto.HeartLungsContent;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model.dto.ProgramContent;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model.dto.TitleContent;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.service.PatientCareServicesService;
import com.hospital.smarthospitalmanagementportal.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/shmp/patientcare")
public class PatientCareServicesController {
    @Autowired
    PatientCareServicesService patientCareServicesService;
    @PostMapping("/heartLungsTransplant")
        ResponseEntity<?> updateHeartLungsTransplant(@RequestBody TitleContent titleContent){
        patientCareServicesService.updateHeartLungsTransplant(titleContent);
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(201);
        response.setData(null);
        response.setMessage("Heart&Lungs Transplant Information Saved Successfully");
        return ResponseEntity.ok(response);
    }
    @PostMapping("/heartLungsTransplant/program")
    ResponseEntity<?> updateHeartLungsTransplant(@RequestBody ProgramContent programContent){
        patientCareServicesService.updateProgramContent(programContent);
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(201);
        response.setData(null);
        response.setMessage("Heart&Lungs Transplant Information Saved Successfully");
        return ResponseEntity.ok(response);
    }
    @PostMapping("/heartLungsTransplant/heartContent")
    ResponseEntity<?> updateHeart(@RequestBody HeartLungsContent heartLungsContent){
        patientCareServicesService.updateHeartContent(heartLungsContent);
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(201);
        response.setData(null);
        response.setMessage("Heart&Lungs Transplant Information Saved Successfully");
        return ResponseEntity.ok(response);
    }
    @PostMapping("/heartLungsTransplant/lungsContent")
    ResponseEntity<?> updateLungs(@RequestBody HeartLungsContent heartLungsContent){
        patientCareServicesService.updateLungsContent(heartLungsContent);
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(201);
        response.setData(null);
        response.setMessage("Heart&Lungs Transplant Information Saved Successfully");
        return ResponseEntity.ok(response);
    }


    @GetMapping("/getHeartLungsTransplant")
    ResponseEntity<?> getHeartlungstransplant(@RequestParam("usage") String usage){
            PatientCareServices patientCareServices = patientCareServicesService.getHeartlungstransplant(usage);
            ApiResponse<PatientCareServices> response = new ApiResponse<>();
            response.setStatus(200);
            response.setData(patientCareServices);
            return ResponseEntity.ok(response);
    }

}
