package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.dto;

public class DashboardData {
    public long appointmentsToday;
    public double slotUtilizationPercent;
    public long cancelledOrRescheduledToday;
    public long availableSlotsToday;
    public long avgApprovalTimeMinutes;
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
}