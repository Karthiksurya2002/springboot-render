package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model.dto;

import java.util.List;

public class ProgramContent {

    private String programTitle;
    private String subProgramTitle;
    private List<String> programExplanation;
    private String updateWhatWeDo;
    private List <String> updateWhatWeDoExplanation;
    private String howWeDo;
    private List <String> howWeDoExplanation ;

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    private String usage;

    public List<String> getProgramExplanation() {
        return programExplanation;
    }

    public void setProgramExplanation(List<String> programExplanation) {
        this.programExplanation = programExplanation;
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
    public List<String> getUpdateWhatWeDoExplanation() {
        return updateWhatWeDoExplanation;
    }

    public void setUpdateWhatWeDoExplanation(List<String> updateWhatWeDoExplanation) {
        this.updateWhatWeDoExplanation = updateWhatWeDoExplanation;
    }
}
