package com.hospital.smarthospitalmanagementportal.admin.imageupload.model.dto;

public class ImageBytesDto  {
    private String contentType;
    private String base64;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
