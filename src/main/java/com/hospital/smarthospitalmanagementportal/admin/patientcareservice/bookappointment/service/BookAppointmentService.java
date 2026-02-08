package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.service;

import com.hospital.smarthospitalmanagementportal.TwilioSmsService;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.BookAppointment;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.BookAppointmentHistory;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.dto.AddDoctor;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.dto.BaOptions;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.dto.Consultation;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.dto.RequestAppointment;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.repo.BookAppointmentRepo;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.repo.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookAppointmentService {
    TwilioSmsService sms;
    @Autowired
    public BookAppointmentService(TwilioSmsService sms) {
        this.sms = sms;
    }

    @Autowired
    BookAppointmentRepo repo;
    @Autowired
    HistoryRepo historyRepo;
    public void updateSpecialties(BaOptions baOptions) {
        BookAppointment ba = new BookAppointment();
        ba.setBaTitle(baOptions.getBaTitle());
        ba.setBaOrLabel(baOptions.getBaOrLabel());
        ba.setBaSearchLabel(baOptions.getBaSearchLabel());
        ba.setBaSpecialties(baOptions.getBaSpecialties());
        ba.setBaSpecialtiesCategory(Collections.singletonList(String.join(",", baOptions.getBaSpecialtiesCategory())));
        ba.setUsage("specialties");
        repo.save(ba);
    }

    public BookAppointment getSpecialties() {
        return repo.findTopByUsageOrderByIdDesc("specialties");
    }

    public Long addDoctor(AddDoctor ad) {
        BookAppointment d = new BookAppointment();
        d.setAdDoctorName(ad.getAdDoctorName());
        d.setAdSpecialties(ad.getAdSpecialties());
        d.setAdDesignation(ad.getAdDesignation());
        d.setAdExperience(ad.getAdExperience());
        d.setAdDoctorName(ad.getAdDoctorName());
        d.setAdAddress(ad.getAdAddress());
        d.setAdConfirmPassword(ad.getAdConfirmPassword());
        d.setAdPassword(ad.getAdPassword());
        d.setAdMobile(ad.getAdMobile());
        d.setAdDepartment(ad.getAdDepartment());
        d.setAdQualification(ad.getAdQualification());
        d.setAdStatus(ad.getAdStatus());
        d.setLoginDetails(ad.getLoginDetails());
        d.setAdUsername(ad.getAdUsername());
        d.setUsage("AllSpecialtiesDoctor");
        d.setAdShift(ad.getAdShift());
        BookAppointment savedId = repo.save(d);
        return savedId.getId();
    }

//    public List<BookAppointment> getDoctor(String specialty, String searchName ,String shift ) {
//
//        specialty = specialty != null ? specialty.trim() : specialty;
//
//        if (searchName == null
//                || searchName.trim().isEmpty()
//                || "undefined".equalsIgnoreCase(searchName)) {
//            searchName = "";
//        }
//
//        boolean isAllSpecialty = "AllSpecialty".equalsIgnoreCase(specialty);
//        boolean hasSearch = !searchName.isEmpty();
//
//        if (isAllSpecialty && !hasSearch) {
//            return repo.findAllByUsage("AllSpecialtiesDoctor");
//        }
//
//
//        if (isAllSpecialty && hasSearch) {
//            return repo.findAllByUsageAndAdDoctorNameContainingIgnoreCase(
//                    "AllSpecialtiesDoctor",
//                    searchName
//            );
//        }
//
//        if (!hasSearch) {
//            return repo.findAllByUsageAndAdSpecialtiesIgnoreCase(
//                    "AllSpecialtiesDoctor",
//                    specialty
//            );
//        }
//
//        return repo.findAllByUsageAndAdSpecialtiesIgnoreCaseAndAdDoctorNameContainingIgnoreCase(
//                "AllSpecialtiesDoctor",
//                specialty,
//                searchName
//        );
//    }
public List<BookAppointment> getDoctor(
        String specialty,
        String searchName,
        String shift
) {

    specialty = specialty != null ? specialty.trim() : "";
    shift = shift != null ? shift.trim() : "";

    if (searchName == null
            || searchName.trim().isEmpty()
            || "undefined".equalsIgnoreCase(searchName)) {
        searchName = "";
    }

    boolean isAllSpecialty = "AllSpecialty".equalsIgnoreCase(specialty);
    boolean hasSearch = !searchName.isEmpty();
    boolean hasShift = !shift.isEmpty();

    if (isAllSpecialty && !hasSearch && !hasShift) {
        return repo.findAllByUsage("AllSpecialtiesDoctor");
    }
    if (isAllSpecialty && hasShift && !hasSearch) {
        return repo.findAllByUsageAndAdShiftIgnoreCase(
                "AllSpecialtiesDoctor",
                shift
        );
    }
    if (isAllSpecialty && hasSearch && hasShift) {
        return repo.findAllByUsageAndAdShiftIgnoreCaseAndAdDoctorNameContainingIgnoreCase(
                "AllSpecialtiesDoctor",
                shift,
                searchName
        );
    }
    if (!isAllSpecialty && hasShift && hasSearch) {
        return repo.findAllByUsageAndAdSpecialtiesIgnoreCaseAndAdShiftIgnoreCaseAndAdDoctorNameContainingIgnoreCase(
                "AllSpecialtiesDoctor",
                specialty,
                shift,
                searchName
        );
    }
    if (!isAllSpecialty && hasShift) {
        return repo.findAllByUsageAndAdSpecialtiesIgnoreCaseAndAdShiftIgnoreCase(
                "AllSpecialtiesDoctor",
                specialty,
                shift
        );
    }
    if (!isAllSpecialty && hasSearch) {
        return repo.findAllByUsageAndAdSpecialtiesIgnoreCaseAndAdDoctorNameContainingIgnoreCase(
                "AllSpecialtiesDoctor",
                specialty,
                searchName
        );
    }
    return repo.findAllByUsageAndAdSpecialtiesIgnoreCase(
            "AllSpecialtiesDoctor",
            specialty
    );
}

    public Optional<BookAppointment> getDoctorDetailsById(Long id) {
        Optional<BookAppointment> ad =repo.findById(id);
        return ad;
    }

    public void updateDoctorById(AddDoctor ad) {

        BookAppointment ba = repo.findById(ad.getId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + ad.getId()));

        ba.setAdDoctorName(ad.getAdDoctorName());
        ba.setAdDesignation(ad.getAdDesignation());
        ba.setAdExperience(ad.getAdExperience());
        ba.setAdSpecialties(ad.getAdSpecialties());

        repo.save(ba);
    }

    public void deleteDoctorById(Long id) {
        repo.deleteById(id);
    }

//    public void reqAppointment(RequestAppointment dto) {
//        BookAppointment entity = new BookAppointment();
//
//        entity.setPatientFirstName(dto.getPatientFirstName());
//        entity.setPatientLastName(dto.getPatientLastName());
//        entity.setPatientAge(dto.getPatientAge());
//        entity.setPatientEmailId(dto.getPatientEmailId());
//        entity.setPatientDOB(dto.getPatientDOB());
//        entity.setPatientAddress(dto.getPatientAddress());
//        entity.setPatientMobile(dto.getPatientMobile());
//        entity.setPatientSpecialty(dto.getPatientSpecialty());
//        entity.setPatientDoctorName(dto.getPatientDoctorName());
//        entity.setPatientGender(dto.getPatientGender());
//        entity.setPatientPreferredDate(dto.getPatientPreferredDate());
//        entity.setOtherDetails(dto.getOtherDetails());
//        entity.setAppointmentDoctorId(dto.getAppointmentDoctorId());
//        entity.setAppointmentUserId(dto.getAppointmentUserId());
//        entity.setAppointmentCreatedAt(LocalDateTime.now());
//        entity.setAppointmentBookedBy(dto.getAppointmentBookedBy());
//        entity.setAppointmentType(dto.getAppointmentType());
//        entity.setAppointmentCreatedBy(dto.getAppointmentCreatedBy());
//        BookAppointment doctor = repo.findById(repo.findById(dto.getAppointmentDoctorId()));
//        entity.setSchuduleDoctor(doctor.getAdDoctorName());
//        String role = dto.getAppointmentCreatedBy();
//        BookAppointment id = repo.save(entity);
//        String opNo =   "OP-" + LocalDate.now().getYear() + "-" + String.format("%06d", id.getId());
//        entity.setOpNumber(opNo);
//        repo.save(entity);
//        saveHistory(
//                opNo,
//                "BOOKED",
//                null,
//                "Pending",
//                role,
//                role,
//                "Appointment booked by patient"
//        );
//    }
public void reqAppointment(RequestAppointment dto) {

    BookAppointment entity = new BookAppointment();

    entity.setPatientFirstName(dto.getPatientFirstName());
    entity.setPatientLastName(dto.getPatientLastName());
    entity.setPatientAge(dto.getPatientAge());
    entity.setPatientEmailId(dto.getPatientEmailId());
    entity.setPatientDOB(dto.getPatientDOB());
    entity.setPatientAddress(dto.getPatientAddress());
    entity.setPatientMobile(dto.getPatientMobile());
    entity.setPatientSpecialty(dto.getPatientSpecialty());
    entity.setPatientDoctorName(dto.getPatientDoctorName());
    entity.setPatientGender(dto.getPatientGender());
    entity.setPatientPreferredDate(dto.getPatientPreferredDate());
    entity.setOtherDetails(dto.getOtherDetails());

    entity.setAppointmentDoctorId(dto.getAppointmentDoctorId());
    entity.setAppointmentUserId(dto.getAppointmentUserId());

    entity.setAppointmentCreatedAt(LocalDateTime.now());
    entity.setAppointmentBookedBy(dto.getAppointmentBookedBy());
    entity.setAppointmentType(dto.getAppointmentType());
    entity.setAppointmentCreatedBy(dto.getAppointmentCreatedBy());
    entity.setSchuduleDoctor(dto.getPatientDoctorName());
    entity.setSlotType(dto.getSlotType());
    entity.setAppointmentStatus("Pending");
    entity.setSelectedSlot(dto.getSelectedSlot());
    String role = dto.getAppointmentCreatedBy();
    BookAppointment saved = repo.save(entity);

    String opNo = "OP-" + LocalDate.now().getYear() + "-" +
            String.format("%06d", saved.getId());

    saved.setOpNumber(opNo);
    repo.save(saved);

    saveHistory(
                opNo,
                "BOOKED",
                null,
                "Pending",
                role,
                role,
                "Appointment booked by patient",
            ""
        );
}

    public List<BookAppointment> getAppointmentList(Long id, String role) {
//        if(role.equalsIgnoreCase("User")){
//            return repo.findByAppointmentUserIdOrderByAppointmentCreatedAtAsc(id);
//
//        } else if (role.equalsIgnoreCase("Admin")){
//            return repo.findByAppointmentBookedByOrderByAppointmentCreatedAtAsc("BookedByUser");
//        }
        if ("USER".equalsIgnoreCase(role)) {
            return repo.findByAppointmentUserIdOrderByAppointmentCreatedAtAsc(id);

        } else if ("ADMIN".equalsIgnoreCase(role)) {
            return repo.findAllByOrderByAppointmentCreatedAtAsc();
        }

        return null;

    }

    public void cancelOp(String id, String role) {
        if(!id.isEmpty()){
            BookAppointment bp = repo.findByOpNumber(id);

            String oldStatus = bp.getAppointmentStatus();
            bp.setAppointmentStatus("Cancelled");
            bp.setCancelledBy(role);
            repo.save(bp);
            saveHistory(
                    id,
                    "CANCELLED",
                    oldStatus,
                    "Cancelled",
                    role,
                    role,
                    "Cancelled before approval",
                    ""
            );
        }
    }

    public void approveOp(String Op, String role) {
        if(!Op.isEmpty()){
            BookAppointment bp = repo.findByOpNumber(Op);
            bp.setAppointmentStatus("Approved");
            bp.setApprovedAppointment(role);
            repo.save(bp);
        }
        BookAppointment bp = repo.findByOpNumber(Op);
        String oldStatus = bp.getAppointmentStatus();
        String performedBy = bp.getApprovedAppointment();
        saveHistory(
                Op,
                "APPROVED",
                oldStatus,
                "Approved",
                performedBy,
                performedBy,
                "Appointment approved by hospital",
                ""
        );
    }
    public void updateNoShow(String opNum , String role){
        BookAppointment ba = repo.findByOpNumber(opNum);
        ba.setAppointmentStatus("NoShow");
        ba.setApprovedAppointment(role);
        repo.save(ba);
        String oldStatus = ba.getAppointmentStatus();
        String performedBy = ba.getApprovedAppointment();
        String comment ="Marked as No Show by"+role;
        saveHistory(
                opNum,
                "No Show",
                oldStatus,
                "No Show",
                role,
                performedBy,
                comment,
                ""

        );
    }
    public void cancelApprovedOp(String op, String role) {

            BookAppointment bp = repo.findByOpNumber(op);
        String oldStatus = bp.getAppointmentStatus();
            bp.setAppointmentStatus("Cancelled_After_Approved");
            bp.setCancelledBy(role);
            bp.setSelectedSlot(null);
            String performedBy = role;
            repo.save(bp);
        saveHistory(
                op,
                "CANCELLED_AFTER_APPROVAL",
                oldStatus,
                "Cancelled_After_Approved",
                performedBy,
                performedBy,
                "Cancelled after hospital approval",
                ""
        );
    }
    private void saveHistory(
            String opNumber,
            String action,
            String oldStatus,
            String newStatus,
            String performedBy,
            String role,
            String remarks,
            String followUpNo
           // LocalDateTime onRescheduleDate
    ) {
        BookAppointmentHistory h = new BookAppointmentHistory();
        h.setOpNumber(opNumber);
        h.setAction(action);
        h.setOldStatus(oldStatus);
        h.setNewStatus(newStatus);
        h.setPerformedBy(performedBy);
        h.setRole(role);
        h.setRemarks(remarks);
        h.setFollowUp(followUpNo);
       // h.setOnRescheduleDate(onRescheduleDate);
        h.setCreatedAt(LocalDateTime.now());

        historyRepo.save(h);
        BookAppointment bp = repo.findByOpNumber(opNumber);
        String message = String.format(
                "Dear %s, Your appointment status has been updated.\n" +
                        "Operation Number: %s\n" +
//                        "New Status: %s\n" +
                        "Appointment Date: %s\n" +
                        "Hospital: %s",
                bp.getPatientFirstName(),
                opNumber,
//                newStatus,
                bp.getAppointmentCreatedAt(),
                "SHMP Hospital"
        );
//        try{
//            sms.send(message);
//        }catch(Exception e){
//            throw new RuntimeException("SMS failed for opNumber"+opNumber);
//        }


    }

    public void rescheduleAppointment(RequestAppointment rescheduleAppointment) {
        BookAppointment ba = repo.findByOpNumber(rescheduleAppointment.getOpNumber());
        ba.setPatientPreferredDate(rescheduleAppointment.getOnRescheduleDate());
        ba.setOnRescheduleReson(rescheduleAppointment.getOnRescheduleReson());
        ba.setSelectedSlot(rescheduleAppointment.getSelectedSlot());
        String oldStatus =rescheduleAppointment.getAppointmentStatus();
        String performedBy =rescheduleAppointment.getRescheduleBy();
        ba.setAppointmentStatus("Rescheduled");
        repo.save(ba);
        saveHistory(
                rescheduleAppointment.getOpNumber(),
                "Reschedule Appointment",
                oldStatus,
                "Reschedule_Appointment",
                performedBy,
                performedBy,
                rescheduleAppointment.getOnRescheduleReson(),
                ""

        );
    }

    public BookAppointment findByAdUsername(String userName) {
        //return  repo.findByAdUsername(userName);
        return repo.findByAdUsernameIgnoreCase(userName.trim());

    }

    public String checkRoleBa(String userName) {
        BookAppointment ba = repo.findByAdUsernameIgnoreCase(userName.trim());
        return ba.getLoginDetails();
    }
    public List<BookAppointment> getDoctorRequestList(Long doctorId) {
        return repo.findByAppointmentDoctorId(doctorId);
    }


    public int checkAvailable(
            String slot,
            Long doctorId,
            LocalDate appointmentDate
    ) {

        int bookedCount =
                repo.countByAppointmentDoctorIdAndPatientPreferredDateAndSelectedSlot(
                        doctorId,
                        appointmentDate,
                        slot
                );


            return bookedCount;
    }

    public BookAppointment getQuickDeatils() {
        BookAppointment dto = new BookAppointment();
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.atTime(23, 59, 59);

        long totalAppointments =
                repo.appointmentsToday(start, end);

        long bookedSlots =
                repo.bookedSlotsToday(start, end);

        dto.appointmentsToday = totalAppointments;

        dto.availableSlotsToday =
                repo.availableSlotsToday(start, end);

        dto.cancelledOrRescheduledToday =
                repo.cancelledOrRescheduledToday(start, end);

        dto.reusedSlots =
                repo.reusedSlots();


        dto.slotUtilizationPercent =
                totalAppointments == 0 ? 0 :
                        (bookedSlots * 100.0) / totalAppointments;


        dto.avgApprovalTimeMinutes =
                calculateAvgApprovalTimeMinutes();

        return dto;
    }
    private long calculateAvgApprovalTimeMinutes() {

        List<Object[]> results = repo.fetchApprovalTimes();

        if (results.isEmpty()) {
            return 0;
        }

        long totalMinutes = 0;
        int count = 0;

        for (Object[] row : results) {

            LocalDateTime createdAt = (LocalDateTime) row[0];
            LocalDate approvedDate = (LocalDate) row[1];

            if (createdAt != null && approvedDate != null) {

                LocalDateTime approvedAt =
                        approvedDate.atStartOfDay();

                long minutes =
                        Duration.between(createdAt, approvedAt).toMinutes();

                totalMinutes += minutes;
                count++;
            }
        }

        return count == 0 ? 0 : totalMinutes / count;
    }

    public BookAppointment getDashboard(Long id, String role) {
        if(role.equalsIgnoreCase("Admin")){
            return getAdminDashboard();
        }else if(role.equalsIgnoreCase("User")){
            return getUserDashboard(id);
        } else if(role.equalsIgnoreCase("Doctor")){
            return getDoctorDashboard(id);
        }
        return null;
    }
    public BookAppointment getUserDashboard(Long userId) {

        BookAppointment dto = new BookAppointment();

        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.atTime(23, 59, 59);

        dto.totalBooked =
                repo.countByAppointmentUserId(userId);

        dto.bookedToday =
                repo.countBookedToday(userId, start, end);

        dto.totalCancelled =
                repo.countByAppointmentUserIdAndAppointmentStatusIn(
                        userId,
                        List.of(
                                "Cancelled",
                                "Cancelled_After_Approved"
                        )
                );

        dto.totalRescheduled =
                repo.countByAppointmentUserIdAndAppointmentStatus(
                        userId,
                        "Rescheduled"
                );

        dto.pending =
                repo.countByAppointmentUserIdAndAppointmentStatus(
                        userId,
                        "Pending"
                );
        dto.completed =
                repo.countByAppointmentUserIdAndAppointmentStatus(
                        userId,
                        "Completed"
                );

        return dto;
    }

    public BookAppointment getDoctorDashboard(Long doctorId) {

        BookAppointment dto = new BookAppointment();


        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.atTime(23, 59, 59);

        dto.totalRequests =
                repo.countByAppointmentDoctorId(doctorId);

        dto.awaitingApproval =
                repo.countByAppointmentDoctorIdAndAppointmentStatus(
                        doctorId,
                        "Pending"
                );

        dto.approvedRequests =
                repo.countByAppointmentDoctorIdAndAppointmentStatus(
                        doctorId,
                        "Approved"
                );

        dto.completedConsultations =
                repo.countByAppointmentDoctorIdAndAppointmentStatus(
                        doctorId,
                        "Completed"
                );

        dto.cancelledRequests =
                repo.countByAppointmentDoctorIdAndAppointmentStatusIn(
                        doctorId,
                        List.of(
                                "Cancelled",
                                "Cancelled_After_Approved"
                        )
                );

        dto.todayRequests =
                repo.countDoctorRequestsToday(
                        doctorId,
                        start,
                        end
                );

        return dto;
    }

    public BookAppointment getAdminDashboard() {

        BookAppointment dto = new BookAppointment();

        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.atTime(23, 59, 59);


        dto.totalAppointments = repo.count();
        dto.appointmentsToday = repo.countAppointmentsToday(start, end);
        dto.completedAppointments =
                repo.countByAppointmentStatus("Completed");
        dto.pendingApprovals =
                repo.countByAppointmentStatus("Pending");
        dto.cancelledAppointments =
                repo.countByAppointmentStatusIn(
                        List.of(
                                "Cancelled",
                                "Cancelled_After_Approved"
                        )
                );


        dto.totalPatients = repo.countTotalPatients();
        dto.newPatientsToday = repo.countNewPatientsToday(start, end);
        dto.activePatients = dto.totalPatients;
        dto.repeatPatients = repo.repeatPatients().size();


        dto.doctorsWithAppointmentsToday =
                repo.countDoctorsWithAppointmentsToday(start, end);
        dto.totalDoctors =
                repo.countDoctorsWithAppointments();
        dto.doctorsWithFreeSlots =
                dto.totalDoctors - dto.doctorsWithAppointmentsToday;


        dto.rescheduledAppointments =
                repo.countByAppointmentStatus("Rescheduled");
        dto.cancelledAfterApproval =
                repo.countByAppointmentStatus(
                        "Cancelled_After_Approved"
                );
        dto.reusedSlots =
                repo.countByAppointmentStatusAndSelectedSlotIsNull(
                        "Cancelled_After_Approved"
                );

        return dto;
    }
public void checkStatus(){
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();

    List<BookAppointment> list =
            repo.findForNoShowCheck(today);
    for(BookAppointment ba : list){
        String oldStatus = ba.getAppointmentStatus();
        ba.setAppointmentStatus("NoShow");
        ba.setSelectedSlot(null);
        String op = ba.getOpNumber();
        saveHistory(
                op,
                "NoShow",
                oldStatus,
                "NoShow",
                "Admin",
                "Admin",
                "Marked as No Show , Please Book New Appoinment.",
                ""
        );
        repo.save(ba);
    }
}

public void saveConsultations(Consultation consultation) {

    BookAppointment oldBa = repo.findByOpNumber(consultation.getOpNumber());

    if (oldBa == null) {
        throw new IllegalArgumentException("Appointment not found");
    }

    if (!"APPROVED".equalsIgnoreCase(oldBa.getAppointmentStatus())) {
        throw new IllegalArgumentException(
                "Only APPROVED appointments can be completed"
        );
    }


    oldBa.setConsultationDoctorId(consultation.getConsultationDoctorId());
    oldBa.setConsultationPatientId(consultation.getConsultationPatientId());
    oldBa.setConsultationClinicNotes(consultation.getConsultationClinicNotes());
    oldBa.setConsultationPrescription(consultation.getConsultationPrescription());
    oldBa.setConsultationAdvice(consultation.getConsultationAdvice());
    oldBa.setConsultationFollowUp(consultation.getConsultationFollowUp());
    String oldStatus = oldBa.getAppointmentStatus();
    String performedBy = consultation.getRole();
    oldBa.setAppointmentStatus("Completed");
    repo.save(oldBa);
    Boolean value = Optional.ofNullable(consultation.getConsultationFollowUp())
            .orElse(Boolean.FALSE);
//    Boolean value = consultation.getConsultationFollowUp();
    String followUpDetails = "" ;
    if(value){
        followUpDetails = "Your Next Appoinment is Sechdule Successfully.";
    }
    saveHistory(
            oldBa.getOpNumber(),
            "Completed",
            oldStatus,
            "Completed",
            performedBy,
            performedBy,
            "Consultation completed",
            followUpDetails
    );

    if (Boolean.TRUE.equals(consultation.getConsultationFollowUp())) {

        BookAppointment followUp = new BookAppointment();
        followUp.setPatientFirstName(oldBa.getPatientFirstName());
        followUp.setPatientLastName(oldBa.getPatientLastName());
        followUp.setPatientAge(oldBa.getPatientAge());
        followUp.setPatientEmailId(oldBa.getPatientEmailId());
        followUp.setPatientDOB(oldBa.getPatientDOB());
        followUp.setPatientAddress(oldBa.getPatientAddress());
        followUp.setPatientMobile(oldBa.getPatientMobile());
        followUp.setPatientSpecialty(oldBa.getPatientSpecialty());
        followUp.setPatientDoctorName(oldBa.getPatientDoctorName());
        followUp.setPatientGender(oldBa.getPatientGender());
//        followUp.setPatientPreferredDate(oldBa.getPatientPreferredDate());
        followUp.setOtherDetails(oldBa.getOtherDetails());

        followUp.setAppointmentDoctorId(oldBa.getAppointmentDoctorId());
        followUp.setAppointmentUserId(oldBa.getAppointmentUserId());

        followUp.setAppointmentCreatedAt(LocalDateTime.now());
        followUp.setAppointmentBookedBy(oldBa.getAppointmentBookedBy());
        followUp.setAppointmentType(oldBa.getAppointmentType());
        followUp.setAppointmentCreatedBy(oldBa.getAppointmentCreatedBy());
        followUp.setSchuduleDoctor(oldBa.getPatientDoctorName());
        followUp.setSlotType( consultation.getConsultationFollowUpSlot());

        followUp.setPatientFirstName(oldBa.getPatientFirstName());
        followUp.setPatientLastName(oldBa.getPatientLastName());
        followUp.setPatientMobile(oldBa.getPatientMobile());
        followUp.setPatientGender(oldBa.getPatientGender());
        followUp.setPatientAge(oldBa.getPatientAge());

        followUp.setAppointmentDoctorId(oldBa.getAppointmentDoctorId());
        followUp.setAppointmentUserId(oldBa.getAppointmentUserId());


        followUp.setAppointmentType("Follow_up");
        followUp.setAppointmentStatus("Approved");
        followUp.setPatientPreferredDate(
                consultation.getConsultationFollowUpDate()
        );
        followUp.setSelectedSlot(
                consultation.getConsultationFollowUpSlot()
        );

        followUp.setAppointmentCreatedAt(LocalDateTime.now());

        followUp.setParentAppointmentId(oldBa.getId());

        followUp.setRootAppointmentId(
                oldBa.getRootAppointmentId() != null
                        ? oldBa.getRootAppointmentId()
                        : oldBa.getId()
        );


        repo.save(followUp);

        String opNo = "OP-" + LocalDate.now().getYear() + "-" +
                String.format("%06d", followUp.getId());

        followUp.setOpNumber(opNo);
        repo.save(followUp);
        String followNo = opNo +  consultation.getConsultationFollowUpDate();
                saveHistory(
                opNo,
                "Approved",
                "New",
                "Approved",
                performedBy,
                performedBy,
                "Auto approved follow-up appointment",
                        followNo
        );


    }
}

    public BookAppointment getOpNumberDetails(String opNumber) {
        if(opNumber != null){
            return repo.findByOpNumber(opNumber);
        }
        return null;
    }

//    public BookAppointment getReport(Long id) {
//       BookAppointment ba = repo.findByIdAndAppointmentStatus(id , "Completed");
//       return  ba;
//    }
    public List<BookAppointment> getReport(Long id, String role) {
        if ("USER".equalsIgnoreCase(role) ||"DOCTOR".equalsIgnoreCase(role)  ) {
            return repo.findByAppointmentUserIdAndAppointmentStatus(id, "Completed");

        } else if ("ADMIN".equalsIgnoreCase(role)) {
            return repo.findAllByAppointmentStatusOrderByAppointmentCreatedAtAsc("Completed");
        }

        return null;

    }

    public Optional<BookAppointment> getUserLoggedInDetails(Long id) {
        Optional<BookAppointment> ba =  repo.findById(id);
        return ba;
    }
}
