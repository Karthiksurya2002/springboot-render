package com.hospital.smarthospitalmanagementportal.admin.dashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dashboardInfo")
public class Dashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private String buttonName;


    private String buttonFacilitiesName;
    private String titleFacilities;

    public String getTitleFacilities() {
        return titleFacilities;
    }

    public void setTitleFacilities(String titleFacilities) {
        this.titleFacilities = titleFacilities;
    }

    //   @ElementCollection
//   @CollectionTable(
//           name="dashboard_facilities",
//           joinColumns = @JoinColumn(name = "dashboard_id")
//   )
//   @Column(name="facilities")
@Column(length = 2000)
   private List<String> facilitiesDetails;

    public List<String> getFacilitiesDetails() {
        return facilitiesDetails;
    }

    public void setFacilitiesDetails(List<String> facilitiesDetails) {
        this.facilitiesDetails = facilitiesDetails;
    }

    private List<String> facilitiesName;

    public List<String> getFacilitiesName() {
        return facilitiesName;
    }

    public void setFacilitiesName(List<String> facilitiesName) {
        this.facilitiesName = facilitiesName;
    }

    @Column(name = "type", nullable = false)
    private String type;   // ✅ MUST EXIST

    // ===== GETTERS & SETTERS (MANDATORY) =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }


    public String getButtonFacilitiesName() {
        return buttonFacilitiesName;
    }

    public void setButtonFacilitiesName(String buttonFacilitiesName) {
        this.buttonFacilitiesName = buttonFacilitiesName;
    }

    public String getType() {          // ✅ REQUIRED
        return type;
    }

    public void setType(String type) { // ✅ REQUIRED
        this.type = type;
    }
}
