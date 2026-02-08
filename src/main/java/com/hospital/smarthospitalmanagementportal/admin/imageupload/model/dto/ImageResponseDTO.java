package com.hospital.smarthospitalmanagementportal.admin.imageupload.model.dto;

public class ImageResponseDTO {

    private Integer id;
    private String contentType;
    private String imageBase64;
    private String message; // optional

    public ImageResponseDTO(Integer id, String contentType, String imageBase64, String message) {
        this.id = id;
        this.contentType = contentType;
        this.imageBase64 = imageBase64;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
// getters
}
