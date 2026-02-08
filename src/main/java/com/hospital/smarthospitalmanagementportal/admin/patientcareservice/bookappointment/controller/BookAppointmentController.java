package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.controller;

import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.BookAppointment;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.BookAppointmentHistory;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.dto.AddDoctor;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.dto.BaOptions;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.dto.Consultation;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.dto.RequestAppointment;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.repo.HistoryRepo;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.service.BookAppointmentService;
import com.hospital.smarthospitalmanagementportal.common.ApiResponse;
import com.hospital.smarthospitalmanagementportal.security.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value="/shmp/patientcare/bookappointment")
public class BookAppointmentController {
    @Autowired
    BookAppointmentService bookAppointmentService;
    @Autowired
    HistoryRepo historyRepo;
    @PostMapping(value ="/updateSpecialties")
    ResponseEntity<?> updateSpecialties(@RequestBody BaOptions baOptions){
        bookAppointmentService.updateSpecialties(baOptions);
        ApiResponse<String> response = new ApiResponse<>();
        response.setData(null);
        response.setStatus(201);
        response.setMessage("Updated Successfully.");
        return ResponseEntity.ok(response);
    }
    @GetMapping(value ="/getSpecialties")
    ResponseEntity<?> getSpecialties(){
        BookAppointment ba = bookAppointmentService.getSpecialties();
        ApiResponse<BookAppointment> response = new ApiResponse<>();
        response.setData(ba);
        response.setStatus(200);
        response.setMessage(null);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value ="/addDoctor")
    ResponseEntity<?> addDoctor(@RequestBody AddDoctor ad){
        Long id = bookAppointmentService.addDoctor(ad);
        ApiResponse<Long> response = new ApiResponse<>();
        response.setData(id);
        response.setStatus(201);
        response.setMessage("New Doctor Profile Added Successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping(value ="/getDoctor")
    ResponseEntity<?> getDoctor(@RequestParam("specialty") String specialty , @RequestParam("searchName") String searchName ,@RequestParam("shfit") String shift){
        List<BookAppointment> ba = bookAppointmentService.getDoctor(specialty , searchName,shift);
        ApiResponse<List <BookAppointment>> response = new ApiResponse<>();
        response.setData(ba);
        response.setStatus(200);
        response.setMessage(null);
        return ResponseEntity.ok(response);
    }
    @GetMapping(value ="/getDoctorById")
    ResponseEntity<?> getDoctorDetailsById(@RequestParam("id") Long id){
        Optional<BookAppointment> ad = bookAppointmentService.getDoctorDetailsById(id);
        ApiResponse< Optional<BookAppointment>> response = new ApiResponse<>();
        response.setData(ad);
        response.setStatus(200);
        response.setMessage(null);
        return ResponseEntity.ok(response);
    }
    @PostMapping(value="/updateDoctorById")
    ResponseEntity<?> updateDoctorById(@RequestBody AddDoctor ad){
        bookAppointmentService.updateDoctorById(ad);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Successfully Update Doctor Information.");
        response.setStatus(201);
        response.setData(null);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value="/deleteDoctorById")
    ResponseEntity<?> deleteDoctorById(@RequestParam("id") Long id){
        bookAppointmentService.deleteDoctorById(id);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Successfully Doctor Information Deleted.");
        response.setStatus(200);
        response.setData(null);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value="/reqAppointment")
    ResponseEntity<?> reqAppointment(@Valid @RequestBody RequestAppointment requestAppointment){
        bookAppointmentService.reqAppointment(requestAppointment);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Scheduled Appointment Successfully, Pls check it in My Request List.");
        response.setStatus(201);
        response.setData(null);
        return ResponseEntity.ok(response);
    }
    @GetMapping(value="/getAppointmentList")
    ResponseEntity<?> getAppointmentList(@RequestParam("id") Long id ,@RequestParam("role") String role){
       List< BookAppointment> ba = bookAppointmentService.getAppointmentList(id ,role);
        ApiResponse<List<BookAppointment>> response = new ApiResponse<>();
        response.setMessage(null);
        response.setStatus(200);
        response.setData(ba);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping(value="/cancelOp")
    ResponseEntity<?> cancelOp(@RequestParam("id") String id , @RequestParam("role") String role){
        bookAppointmentService.cancelOp(id , role);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Successfully Op is canceled");
        response.setStatus(200);
        response.setData(null);
        return ResponseEntity.ok(response);
    }
    @PostMapping(value="/approveOp")
    ResponseEntity<?> approveOp(@RequestParam("id") String approveOp ,  @RequestParam("role") String role){
        bookAppointmentService.approveOp(approveOp , role);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Appointment Confirmed");
        response.setStatus(200);
        response.setData(null);
        return ResponseEntity.ok(response);
    }
    @PostMapping(value="/noshow")
    ResponseEntity<?> updateNoShow(@RequestParam("opNum") String op , @RequestParam("role") String role){
        bookAppointmentService.updateNoShow(op , role);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Marked As No Show.");
        response.setStatus(200);
        response.setData(null);
        return ResponseEntity.ok(response);
    }
    @PostMapping(value="/cancelApprovedOp")
    ResponseEntity<?> cancelApprovedOp(@RequestParam("id") String id ,  @RequestParam("role") String role){
        bookAppointmentService.cancelApprovedOp(id , role);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Appointment Confirmed");
        response.setStatus(200);
        response.setData(null);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/checkStatus")
    ResponseEntity<?> checkStatus(){
        bookAppointmentService.checkStatus();
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage(null);
        response.setStatus(200);
        response.setData(null);
        return ResponseEntity.ok(response);
    }
    @PostMapping(value="/rescheduleAppointment")
    ResponseEntity<?> rescheduleAppointment(@RequestBody  RequestAppointment rescheduleAppointment){
        bookAppointmentService.rescheduleAppointment(rescheduleAppointment);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Appointment Confirmed");
        response.setStatus(200);
        response.setData(null);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getAppointmentHistory")
    public ResponseEntity<?> getAppointmentHistory(
            @RequestParam("opNumber") String opNumber) {

        List<BookAppointmentHistory> history =
                historyRepo.findByOpNumberOrderByCreatedAtAsc(opNumber);

        ApiResponse<List<BookAppointmentHistory>> response = new ApiResponse<>();
        response.setData(history);
        response.setStatus(200);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getDoctorList")
    ResponseEntity<?> getDoctorRequestList(@RequestParam("id") Long id){
       List<BookAppointment> list = bookAppointmentService.getDoctorRequestList(id);
        ApiResponse<  List<BookAppointment>> response = new ApiResponse<>();
        response.setMessage(null);
        response.setStatus(200);
        response.setData(list);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/checkSlotAvailability")
    ResponseEntity<?> checkSlotAvailability(
            @RequestParam Long doctorId,
            @RequestParam String slot,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        int count = bookAppointmentService.checkAvailable(slot, doctorId, date);
        String message;
        int data = 0;
        if(count>=2){
            message = "This time slot is already fully booked. Please select another slot.";
            data = 1;
        }else{
            message = "Slot is Available.";
            data =0;
        }
        ApiResponse<Integer> response = new ApiResponse<>();
        response.setStatus(200);
        response.setMessage(message);
        response.setData(data);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getQuickDeatils")
     ResponseEntity<?> getQuickDeatils(){
        BookAppointment b = bookAppointmentService.getQuickDeatils();
        if(b!=null){
            ApiResponse<BookAppointment> response = new ApiResponse<>();
            response.setStatus(200);
            response.setMessage("");
                response.setData(b);
            return ResponseEntity.ok(response);
        }
    return null;
    }
    @GetMapping("/getDashboard")
    public ResponseEntity<?> getDashboard(@RequestParam("id") Long id ,@RequestParam("role") String role ){
       BookAppointment b = bookAppointmentService.getDashboard(id ,role);
        ApiResponse<BookAppointment> response = new ApiResponse<>();
        response.setStatus(200);
        response.setMessage("");
        response.setData(b);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/saveConsultations")
    public ResponseEntity<?> saveConsultations(@RequestBody Consultation consultation){
        bookAppointmentService.saveConsultations(consultation);
        ApiResponse<?> response = new ApiResponse<>();
        response.setStatus(200);
        response.setMessage("Successfully Saved.");
        response.setData(null);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getOpNumberDetails")
    public ResponseEntity<?> getOpNumberDetails(@RequestParam("opNumber") String opNumber){
        BookAppointment ba = bookAppointmentService.getOpNumberDetails(opNumber);
        ApiResponse<BookAppointment> response = new ApiResponse<>();
        if(ba != null){
            response.setStatus(200);
            response.setMessage(null);
            response.setData(ba);
            return ResponseEntity.ok(response);
        }else{
            response.setStatus(200);
            response.setMessage("No Details Found for this OpNumber.");
            response.setData(null);
            return ResponseEntity.ok(response);
        }
    }
    @GetMapping("/getReports")
    ResponseEntity<?> getReports(@RequestParam("id") Long id ,@RequestParam("role") String role){
       List<BookAppointment> ba = bookAppointmentService.getReport(id,role);
        ApiResponse<List<BookAppointment>> response = new ApiResponse<>();
        response.setStatus(200);
        response.setMessage(null);
        response.setData(ba);
        return ResponseEntity.ok(response);
    }
    @GetMapping(value="/getUserDetailss")
    public ResponseEntity<?> getUserLoggedInDetails(@RequestParam("id") Long id){
        Optional<BookAppointment> user = bookAppointmentService.getUserLoggedInDetails(id);
        ApiResponse< Optional<BookAppointment>> response = new ApiResponse<>();
        response.setMessage(null);
        response.setData(user);
        response.setStatus(200);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
