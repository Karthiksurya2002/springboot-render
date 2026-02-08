package com.hospital.smarthospitalmanagementportal.admin.dashboard.model.dto;

import java.util.List;

public class FacilitiesDetails {

    private List<String> facilitiesDetails;
    private String buttonName;
    private String titleFacilities;

    public String getTitleFacilities() {
        return titleFacilities;
    }

    public void setTitleFacilities(String titleFacilities) {
        this.titleFacilities = titleFacilities;
    }

    public List<String> getFacilitiesDetails() {
        return facilitiesDetails;
    }

    public void setFacilitiesDetails(List<String> facilitiesDetails) {
        this.facilitiesDetails = facilitiesDetails;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }
}
