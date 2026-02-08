package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model.dto;

import jakarta.persistence.Column;

import java.util.List;

public class HeartLungsContent {
    private String heartTitle;
    @Column(length = 2000)
    private String heartContent;
    @Column(length = 5000)
    private List<String> heartContentExpln;
    private String lungsTitle;
    @Column(length = 2000)
    private String lungsContent;
    @Column(length = 5000)
    private List<String>lungsContentExpln;

    public String getHeartTitle() {
        return heartTitle;
    }

    public void setHeartTitle(String heartTitle) {
        this.heartTitle = heartTitle;
    }

    public String getHeartContent() {
        return heartContent;
    }

    public void setHeartContent(String heartContent) {
        this.heartContent = heartContent;
    }

    public List<String> getHeartContentExpln() {
        return heartContentExpln;
    }

    public void setHeartContentExpln(List<String> heartContentExpln) {
        this.heartContentExpln = heartContentExpln;
    }

    public String getLungsTitle() {
        return lungsTitle;
    }

    public void setLungsTitle(String lungsTitle) {
        this.lungsTitle = lungsTitle;
    }

    public String getLungsContent() {
        return lungsContent;
    }

    public void setLungsContent(String lungsContent) {
        this.lungsContent = lungsContent;
    }

    public List<String> getLungsContentExpln() {
        return lungsContentExpln;
    }

    public void setLungsContentExpln(List<String> lungsContentExpln) {
        this.lungsContentExpln = lungsContentExpln;
    }
}
