package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.dto;

public class AddDoctor {
    private Long id;
    private String adSpecialties;
    private String adDoctorName;
    private String adDesignation;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
