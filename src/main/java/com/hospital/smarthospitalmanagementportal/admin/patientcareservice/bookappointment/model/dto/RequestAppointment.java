package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RequestAppointment {

    @NotBlank
    private String patientFirstName;
    private Long appointmentUserId;
    private String patientLastName;

    private Integer patientAge;

    @Email
    private String patientEmailId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate patientDOB;

    private String patientAddress;

    private String patientMobile;

    private String patientSpecialty;

    private String patientDoctorName;

    private String patientGender;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate patientPreferredDate;

    private String otherDetails;

    private String opNumber;
    private Long appointmentDoctorId;
    private LocalDateTime appointmentCreatedAt;
    private String appointmentType;
    private String appointmentStatus;
    private String cancelApproved;
    private String onRescheduleReson;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate onRescheduleDate;
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

    public String getRescheduleBy() {
        return rescheduleBy;
    }

    public void setRescheduleBy(String rescheduleBy) {
        this.rescheduleBy = rescheduleBy;
    }

    private String rescheduleBy;
    public String getAppointmentCreatedBy() {
        return appointmentCreatedBy;
    }

    public void setAppointmentCreatedBy(String appointmentCreatedBy) {
        this.appointmentCreatedBy = appointmentCreatedBy;
    }

    public LocalDate getOnRescheduleDate() {
        return onRescheduleDate;
    }

    public void setOnRescheduleDate(LocalDate onRescheduleDate) {
        this.onRescheduleDate = onRescheduleDate;
    }

    public String getOnRescheduleReson() {
        return onRescheduleReson;
    }

    public void setOnRescheduleReson(String onRescheduleReson) {
        this.onRescheduleReson = onRescheduleReson;
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

    private String appointmentBookedBy;

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

    @Transient
    public long totalBooked;
    @Transient
    public long bookedToday;
    @Transient
    public long totalCancelled;
    @Transient
    public long totalRescheduled;
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
    public long pending;

    public long getPending() {
        return pending;
    }

    public void setPending(long pending) {
        this.pending = pending;
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
}
