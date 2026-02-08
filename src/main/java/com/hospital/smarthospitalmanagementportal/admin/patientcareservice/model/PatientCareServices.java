package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "patientcare")
public class PatientCareServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 5000)
    private String title;
    @Column(length = 5000)
    private List<String> content;
    private String usage;

    private String programTitle;
    @Column(length = 5000)
    private String subProgramTitle;
    @Column(length = 5000)
    private List <String> programExplanation;
    @Column(length = 5000)
    private String updateWhatWeDo;
    @Column(length = 5000)
    private List<String> updateWhatWeDoExplanation;
    @Column(length = 5000)
    private String howWeDo;
    @Column(length = 5000)
    private List <String> howWeDoExplanation ;


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

    public List<String> getProgramExplanation() {
        return programExplanation;
    }

    public void setProgramExplanation(List<String> programExplanation) {
        this.programExplanation = programExplanation;
    }

    public List<String> getUpdateWhatWeDoExplanation() {
        return updateWhatWeDoExplanation;
    }

    public void setUpdateWhatWeDoExplanation(List<String> updateWhatWeDoExplanation) {
        this.updateWhatWeDoExplanation = updateWhatWeDoExplanation;
    }

    public List<String> getHowWeDoExplanation() {
        return howWeDoExplanation;
    }

    public void setHowWeDoExplanation(List<String> howWeDoExplanation) {
        this.howWeDoExplanation = howWeDoExplanation;
    }

    public String getProgramTitle() {
        return programTitle;
    }

    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }

    public String getSubProgramTitle() {
        return subProgramTitle;
    }

    public void setSubProgramTitle(String subProgramTitle) {
        this.subProgramTitle = subProgramTitle;
    }



    public String getUpdateWhatWeDo() {
        return updateWhatWeDo;
    }

    public void setUpdateWhatWeDo(String updateWhatWeDo) {
        this.updateWhatWeDo = updateWhatWeDo;
    }


    public String getHowWeDo() {
        return howWeDo;
    }

    public void setHowWeDo(String howWeDo) {
        this.howWeDo = howWeDo;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

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

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}