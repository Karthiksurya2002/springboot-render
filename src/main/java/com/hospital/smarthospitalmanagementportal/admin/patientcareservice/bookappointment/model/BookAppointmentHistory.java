package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment_history")
public class BookAppointmentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String opNumber;

    private String action;

    private String oldStatus;
    private String newStatus;

    private String performedBy;
    private String role;

    @Column(length = 500)
    private String remarks;

    private LocalDateTime createdAt;
    private String onRescheduleReson;
    private LocalDateTime onRescheduleDate;
    private String cancelledBy;
    private String followUp ;

    public String getFollowUp() {
        return followUp;
    }

    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }

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

    public LocalDateTime getOnRescheduleDate() {
        return onRescheduleDate;
    }

    public void setOnRescheduleDate(LocalDateTime onRescheduleDate) {
        this.onRescheduleDate = onRescheduleDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpNumber() {
        return opNumber;
    }

    public void setOpNumber(String opNumber) {
        this.opNumber = opNumber;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
// getters & setters
}
