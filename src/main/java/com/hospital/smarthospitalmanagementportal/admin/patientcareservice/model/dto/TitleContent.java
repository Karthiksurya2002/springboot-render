package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model.dto;

import java.util.List;

public class TitleContent {
    private String title;
    private List<String> content;
    private String usage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
}
