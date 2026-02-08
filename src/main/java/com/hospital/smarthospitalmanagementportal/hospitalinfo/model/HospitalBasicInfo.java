package com.hospital.smarthospitalmanagementportal.hospitalinfo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@Table( name = "hospitalbasicinfo")
public class HospitalBasicInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    int year ;
    Long phoneNo;

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }
    @ElementCollection
    @CollectionTable(
            name = "hospital_footer_info",
            joinColumns = @JoinColumn(name = "hospital_id")
    )
    @MapKeyColumn(name = "footer_key")
    @Column(name = "footer_value")
    Map<String ,String> footerInfo;

    public Map<String, String> getFooterInfo() {
        return footerInfo;
    }

    public void setFooterInfo(Map<String, String> footerInfo) {
        this.footerInfo = footerInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
