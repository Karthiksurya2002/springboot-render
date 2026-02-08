package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.dto;

import java.time.LocalDate;

public class Consultation {
    private String role;
    private Long consultationPatientId;
    private Long consultationDoctorId;
    private String consultationClinicNotes;
    private String consultationPrescription;
    private String consultationAdvice;
    private Boolean consultationFollowUp;
    private LocalDate consultationFollowUpDate;
    private String consultationFollowUpSlot;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOpNumber() {
        return opNumber;
    }

    public void setOpNumber(String opNumber) {
        this.opNumber = opNumber;
    }

    private String opNumber;

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
