package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BaOptions {

    private String baTitle;
    private String baSpecialties;
    private List<String> baSpecialtiesCategory;
    private String baOrLabel;
    private String baSearchLabel;
    private String usage;

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
}
