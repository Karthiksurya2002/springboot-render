package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="bookappointment")
public class BookAppointment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String baTitle;
    private String baSpecialties;
    @Column(length = 500)
    private List<String> baSpecialtiesCategory;
    private String baOrLabel;
    private String baSearchLabel;
    private String usage;


    private String adSpecialties;
    private String adDoctorName;
    private String adDesignation;
    @Column(name = "experience")
    private int adExperience;
    private String adUsername;
    private String adPassword;
    private String adConfirmPassword;
    private String adDepartment;
    private String adQualification;
    private String adAddress;
    private Long adMobile;
    private String adStatus;
    private String adShift;

    public String getAdShift() {
        return adShift;
    }

    public void setAdShift(String adShift) {
        this.adShift = adShift;
    }
    public String getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(String loginDetails) {
        this.loginDetails = loginDetails;
    }

    private String loginDetails;

    public String getAdUsername() {
        return adUsername;
    }

    public void setAdUsername(String adUsername) {
        this.adUsername = adUsername;
    }

    public String getAdPassword() {
        return adPassword;
    }

    public void setAdPassword(String adPassword) {
        this.adPassword = adPassword;
    }

    public String getAdConfirmPassword() {
        return adConfirmPassword;
    }

    public void setAdConfirmPassword(String adConfirmPassword) {
        this.adConfirmPassword = adConfirmPassword;
    }

    public String getAdDepartment() {
        return adDepartment;
    }

    public void setAdDepartment(String adDepartment) {
        this.adDepartment = adDepartment;
    }

    public String getAdQualification() {
        return adQualification;
    }

    public void setAdQualification(String adQualification) {
        this.adQualification = adQualification;
    }

    public String getAdAddress() {
        return adAddress;
    }

    public void setAdAddress(String adAddress) {
        this.adAddress = adAddress;
    }

    public Long getAdMobile() {
        return adMobile;
    }

    public void setAdMobile(Long adMobile) {
        this.adMobile = adMobile;
    }

    public String getAdStatus() {
        return adStatus;
    }

    public void setAdStatus(String adStatus) {
        this.adStatus = adStatus;
    }

    private String patientFirstName;
    private String patientLastName;
    private Integer patientAge;
    private String patientEmailId;
    private LocalDate patientDOB;
    private String patientAddress;
    private String patientMobile;
    private String patientSpecialty;
    private String patientDoctorName;
    private String patientGender;
    private LocalDate patientPreferredDate;
    private String otherDetails;
    private String opNumber;
    private Long appointmentDoctorId;
    private LocalDateTime appointmentCreatedAt;
    private String appointmentType;
    private String appointmentBookedBy;
    private String appointmentStatus;
    private String cancelApproved;
    private String onRescheduleReson;
    private LocalDate onRescheduleDate;
    private String cancelledBy;
    private String rescheduleBy;
    private String appointmentCreatedBy;
    private String schuduleDoctor;
    private String selectedSlot;
    private String slotType;

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public String getSelectedSlot() {
        return selectedSlot;
    }

    public void setSelectedSlot(String selectedSlot) {
        this.selectedSlot = selectedSlot;
    }

    public String getSchuduleDoctor() {
        return schuduleDoctor;
    }

    public void setSchuduleDoctor(String schuduleDoctor) {
        this.schuduleDoctor = schuduleDoctor;
    }

    public String getAppointmentCreatedBy() {
        return appointmentCreatedBy;
    }

    public void setAppointmentCreatedBy(String appointmentCreatedBy) {
        this.appointmentCreatedBy = appointmentCreatedBy;
    }
    public String getRescheduleBy() {
        return rescheduleBy;
    }

    public void setRescheduleBy(String rescheduleBy) {
        this.rescheduleBy = rescheduleBy;
    }

    public String getApprovedAppointment() {
        return approvedAppointment;
    }

    public void setApprovedAppointment(String approvedAppointment) {
        this.approvedAppointment = approvedAppointment;
    }

    private String approvedAppointment;
    public String getCancelledBy() {
        return cancelledBy;
    }

    public void setCancelledBy(String cancelledBy) {
        this.cancelledBy = cancelledBy;
    }

    public String getOnRescheduleReson() {
        return onRescheduleReson;
    }

    public void setOnRescheduleReson(String onRescheduleReson) {
        this.onRescheduleReson = onRescheduleReson;
    }

    public LocalDate getOnRescheduleDate() {
        return onRescheduleDate;
    }

    public void setOnRescheduleDate(LocalDate onRescheduleDate) {
        this.onRescheduleDate = onRescheduleDate;
    }

    public String getCancelApproved() {
        return cancelApproved;
    }

    public void setCancelApproved(String cancelApproved) {
        this.cancelApproved = cancelApproved;
    }
    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentBookedBy() {
        return appointmentBookedBy;
    }

    public void setAppointmentBookedBy(String appointmentBookedBy) {
        this.appointmentBookedBy = appointmentBookedBy;
    }
    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
    public LocalDateTime getAppointmentCreatedAt() {
        return appointmentCreatedAt;
    }

    public void setAppointmentCreatedAt(LocalDateTime appointmentCreatedAt) {
        this.appointmentCreatedAt = appointmentCreatedAt;
    }
    public Long getAppointmentUserId() {
        return appointmentUserId;
    }

    public void setAppointmentUserId(Long appointmentUserId) {
        this.appointmentUserId = appointmentUserId;
    }

    private Long appointmentUserId;
    public Long getAppointmentDoctorId() {
        return appointmentDoctorId;
    }

    public void setAppointmentDoctorId(Long appointmentDoctorId) {
        this.appointmentDoctorId = appointmentDoctorId;
    }
    public String getOpNumber() {
        return opNumber;
    }

    public void setOpNumber(String opNumber) {
        this.opNumber = opNumber;
    }


    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientEmailId() {
        return patientEmailId;
    }

    public void setPatientEmailId(String patientEmailId) {
        this.patientEmailId = patientEmailId;
    }

    public LocalDate getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(LocalDate patientDOB) {
        this.patientDOB = patientDOB;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    public String getPatientSpecialty() {
        return patientSpecialty;
    }

    public void setPatientSpecialty(String patientSpecialty) {
        this.patientSpecialty = patientSpecialty;
    }

    public String getPatientDoctorName() {
        return patientDoctorName;
    }

    public void setPatientDoctorName(String patientDoctorName) {
        this.patientDoctorName = patientDoctorName;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public LocalDate getPatientPreferredDate() {
        return patientPreferredDate;
    }

    public void setPatientPreferredDate(LocalDate patientPreferredDate) {
        this.patientPreferredDate = patientPreferredDate;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public String getAdSpecialties() {
        return adSpecialties;
    }

    public void setAdSpecialties(String adSpecialties) {
        this.adSpecialties = adSpecialties;
    }

    public String getAdDoctorName() {
        return adDoctorName;
    }

    public void setAdDoctorName(String adDoctorName) {
        this.adDoctorName = adDoctorName;
    }

    public String getAdDesignation() {
        return adDesignation;
    }

    public void setAdDesignation(String adDesignation) {
        this.adDesignation = adDesignation;
    }

    public int getAdExperience() {
        return adExperience;
    }

    public void setAdExperience(int adExperience) {
        this.adExperience = adExperience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBaTitle() {
        return baTitle;
    }

    public void setBaTitle(String baTitle) {
        this.baTitle = baTitle;
    }

    public String getBaSpecialties() {
        return baSpecialties;
    }

    public void setBaSpecialties(String baSpecialties) {
        this.baSpecialties = baSpecialties;
    }

    public List<String> getBaSpecialtiesCategory() {
        return baSpecialtiesCategory;
    }

    public void setBaSpecialtiesCategory(List<String> baSpecialtiesCategory) {
        this.baSpecialtiesCategory = baSpecialtiesCategory;
    }

    public String getBaOrLabel() {
        return baOrLabel;
    }

    public void setBaOrLabel(String baOrLabel) {
        this.baOrLabel = baOrLabel;
    }

    public String getBaSearchLabel() {
        return baSearchLabel;
    }

    public void setBaSearchLabel(String baSearchLabel) {
        this.baSearchLabel = baSearchLabel;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
   @Transient
    public long appointmentsToday;
    @Transient
    public double slotUtilizationPercent;
    @Transient
    public long cancelledOrRescheduledToday;
    @Transient
    public long availableSlotsToday;
    @Transient
    public long avgApprovalTimeMinutes;
    @Transient
    public long reusedSlots;

    public long getAppointmentsToday() {
        return appointmentsToday;
    }

    public void setAppointmentsToday(long appointmentsToday) {
        this.appointmentsToday = appointmentsToday;
    }

    public double getSlotUtilizationPercent() {
        return slotUtilizationPercent;
    }

    public void setSlotUtilizationPercent(double slotUtilizationPercent) {
        this.slotUtilizationPercent = slotUtilizationPercent;
    }

    public long getCancelledOrRescheduledToday() {
        return cancelledOrRescheduledToday;
    }

    public void setCancelledOrRescheduledToday(long cancelledOrRescheduledToday) {
        this.cancelledOrRescheduledToday = cancelledOrRescheduledToday;
    }

    public long getAvailableSlotsToday() {
        return availableSlotsToday;
    }

    public void setAvailableSlotsToday(long availableSlotsToday) {
        this.availableSlotsToday = availableSlotsToday;
    }

    public long getAvgApprovalTimeMinutes() {
        return avgApprovalTimeMinutes;
    }

    public void setAvgApprovalTimeMinutes(long avgApprovalTimeMinutes) {
        this.avgApprovalTimeMinutes = avgApprovalTimeMinutes;
    }

    public long getReusedSlots() {
        return reusedSlots;
    }

    public void setReusedSlots(long reusedSlots) {
        this.reusedSlots = reusedSlots;
    }

    @Transient
    public long totalBooked;
    @Transient
    public long bookedToday;
    @Transient
    public long totalCancelled;
    @Transient
    public long totalRescheduled;
    @Transient
    public long pending;

    public long getPending() {
        return pending;
    }

    public void setPending(long pending) {
        this.pending = pending;
    }

    @Transient
    public long completed;

    public long getTotalBooked() {
        return totalBooked;
    }

    public void setTotalBooked(long totalBooked) {
        this.totalBooked = totalBooked;
    }

    public long getBookedToday() {
        return bookedToday;
    }

    public void setBookedToday(long bookedToday) {
        this.bookedToday = bookedToday;
    }

    public long getTotalCancelled() {
        return totalCancelled;
    }

    public void setTotalCancelled(long totalCancelled) {
        this.totalCancelled = totalCancelled;
    }

    public long getTotalRescheduled() {
        return totalRescheduled;
    }

    public void setTotalRescheduled(long totalRescheduled) {
        this.totalRescheduled = totalRescheduled;
    }

    public long getCompleted() {
        return completed;
    }

    public void setCompleted(long completed) {
        this.completed = completed;
    }

    @Transient
    public long totalRequests;
    @Transient
    public long awaitingApproval;
    @Transient
    public long approvedRequests;
    @Transient
    public long cancelledRequests;
    @Transient
    public long completedConsultations;
    @Transient
    public long todayRequests;

    public long getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(long totalRequests) {
        this.totalRequests = totalRequests;
    }

    public long getAwaitingApproval() {
        return awaitingApproval;
    }

    public void setAwaitingApproval(long awaitingApproval) {
        this.awaitingApproval = awaitingApproval;
    }

    public long getApprovedRequests() {
        return approvedRequests;
    }

    public void setApprovedRequests(long approvedRequests) {
        this.approvedRequests = approvedRequests;
    }

    public long getCancelledRequests() {
        return cancelledRequests;
    }

    public void setCancelledRequests(long cancelledRequests) {
        this.cancelledRequests = cancelledRequests;
    }

    public long getCompletedConsultations() {
        return completedConsultations;
    }

    public void setCompletedConsultations(long completedConsultations) {
        this.completedConsultations = completedConsultations;
    }

    public long getTodayRequests() {
        return todayRequests;
    }

    public void setTodayRequests(long todayRequests) {
        this.todayRequests = todayRequests;
    }

    @Transient
    public long totalAppointments;
//    public long appointmentsToday;
    @Transient
    public long completedAppointments;
    @Transient
    public long pendingApprovals;
    @Transient
    public long cancelledAppointments;

    // Patient
    @Transient
    public long totalPatients;
    @Transient
    public long newPatientsToday;
    @Transient
    public long activePatients;
    @Transient
    public long repeatPatients;

    // Doctor
    @Transient
    public long totalDoctors;
    @Transient
    public long doctorsWithAppointmentsToday;
    @Transient
    public long doctorsWithFreeSlots;


    // Operational
    @Transient
    public long rescheduledAppointments;
    @Transient
    public long cancelledAfterApproval;
    @Transient
    public long totalReusedSlots;

    public long getTotalAppointments() {
        return totalAppointments;
    }

    public void setTotalAppointments(long totalAppointments) {
        this.totalAppointments = totalAppointments;
    }

    public long getCompletedAppointments() {
        return completedAppointments;
    }

    public void setCompletedAppointments(long completedAppointments) {
        this.completedAppointments = completedAppointments;
    }

    public long getPendingApprovals() {
        return pendingApprovals;
    }

    public void setPendingApprovals(long pendingApprovals) {
        this.pendingApprovals = pendingApprovals;
    }

    public long getCancelledAppointments() {
        return cancelledAppointments;
    }

    public void setCancelledAppointments(long cancelledAppointments) {
        this.cancelledAppointments = cancelledAppointments;
    }

    public long getTotalPatients() {
        return totalPatients;
    }

    public void setTotalPatients(long totalPatients) {
        this.totalPatients = totalPatients;
    }

    public long getNewPatientsToday() {
        return newPatientsToday;
    }

    public void setNewPatientsToday(long newPatientsToday) {
        this.newPatientsToday = newPatientsToday;
    }

    public long getActivePatients() {
        return activePatients;
    }

    public void setActivePatients(long activePatients) {
        this.activePatients = activePatients;
    }

    public long getRepeatPatients() {
        return repeatPatients;
    }

    public void setRepeatPatients(long repeatPatients) {
        this.repeatPatients = repeatPatients;
    }

    public long getTotalDoctors() {
        return totalDoctors;
    }

    public void setTotalDoctors(long totalDoctors) {
        this.totalDoctors = totalDoctors;
    }

    public long getDoctorsWithAppointmentsToday() {
        return doctorsWithAppointmentsToday;
    }

    public void setDoctorsWithAppointmentsToday(long doctorsWithAppointmentsToday) {
        this.doctorsWithAppointmentsToday = doctorsWithAppointmentsToday;
    }

    public long getDoctorsWithFreeSlots() {
        return doctorsWithFreeSlots;
    }

    public void setDoctorsWithFreeSlots(long doctorsWithFreeSlots) {
        this.doctorsWithFreeSlots = doctorsWithFreeSlots;
    }

    public long getRescheduledAppointments() {
        return rescheduledAppointments;
    }

    public void setRescheduledAppointments(long rescheduledAppointments) {
        this.rescheduledAppointments = rescheduledAppointments;
    }

    public long getCancelledAfterApproval() {
        return cancelledAfterApproval;
    }

    public void setCancelledAfterApproval(long cancelledAfterApproval) {
        this.cancelledAfterApproval = cancelledAfterApproval;
    }

    public long getTotalReusedSlots() {
        return totalReusedSlots;
    }

    public void setTotalReusedSlots(long totalReusedSlots) {
        this.totalReusedSlots = totalReusedSlots;
    }

    private Long consultationPatientId;
    private Long consultationDoctorId;
    private String consultationClinicNotes;
    private String consultationPrescription;
    private String consultationAdvice;
    private Boolean consultationFollowUp;
    private LocalDate consultationFollowUpDate;
    private String consultationFollowUpSlot;
    private Long parentAppointmentId;
    private Long rootAppointmentId;

    public Long getParentAppointmentId() {
        return parentAppointmentId;
    }

    public void setParentAppointmentId(Long parentAppointmentId) {
        this.parentAppointmentId = parentAppointmentId;
    }

    public Long getRootAppointmentId() {
        return rootAppointmentId;
    }

    public void setRootAppointmentId(Long rootAppointmentId) {
        this.rootAppointmentId = rootAppointmentId;
    }

    public Long getConsultationPatientId() {
        return consultationPatientId;
    }

    public void setConsultationPatientId(Long consultationPatientId) {
        this.consultationPatientId = consultationPatientId;
    }

    public Long getConsultationDoctorId() {
        return consultationDoctorId;
    }

    public void setConsultationDoctorId(Long consultationDoctorId) {
        this.consultationDoctorId = consultationDoctorId;
    }

    public String getConsultationClinicNotes() {
        return consultationClinicNotes;
    }

    public void setConsultationClinicNotes(String consultationClinicNotes) {
        this.consultationClinicNotes = consultationClinicNotes;
    }

    public String getConsultationPrescription() {
        return consultationPrescription;
    }

    public void setConsultationPrescription(String consultationPrescription) {
        this.consultationPrescription = consultationPrescription;
    }

    public String getConsultationAdvice() {
        return consultationAdvice;
    }

    public void setConsultationAdvice(String consultationAdvice) {
        this.consultationAdvice = consultationAdvice;
    }

    public Boolean getConsultationFollowUp() {
        return consultationFollowUp;
    }

    public void setConsultationFollowUp(Boolean consultationFollowUp) {
        this.consultationFollowUp = consultationFollowUp;
    }

    public LocalDate getConsultationFollowUpDate() {
        return consultationFollowUpDate;
    }

    public void setConsultationFollowUpDate(LocalDate consultationFollowUpDate) {
        this.consultationFollowUpDate = consultationFollowUpDate;
    }

    public String getConsultationFollowUpSlot() {
        return consultationFollowUpSlot;
    }

    public void setConsultationFollowUpSlot(String consultationFollowUpSlot) {
        this.consultationFollowUpSlot = consultationFollowUpSlot;
    }
}
