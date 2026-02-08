package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.service;

import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model.PatientCareServices;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model.dto.HeartLungsContent;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model.dto.ProgramContent;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model.dto.TitleContent;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.repo.PatientCareServicesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PatientCareServicesService {
    @Autowired
    PatientCareServicesRepo patientCareServicesRepo;
    public void updateHeartLungsTransplant(TitleContent titleContent) {
        PatientCareServices data = new PatientCareServices();
        data.setTitle(titleContent.getTitle());
        data.setContent(
                Collections.singletonList(String.join("," ,titleContent.getContent()))
                        );
        data.setUsage(titleContent.getUsage());
        patientCareServicesRepo.save(data);
    }

    public PatientCareServices getHeartlungstransplant(String usage) {
        //System.out.print(patientCareServicesRepo.findAll());
        return  patientCareServicesRepo.findTopByUsageOrderByIdDesc(usage);
    }

    public void updateProgramContent(ProgramContent programContent) {
        PatientCareServices data = new PatientCareServices();
        data.setProgramTitle(programContent.getProgramTitle());
        data.setSubProgramTitle(programContent.getSubProgramTitle());
        data.setProgramExplanation( Collections.singletonList(String.join("," ,programContent.getProgramExplanation())));
        data.setUpdateWhatWeDo(programContent.getUpdateWhatWeDo());
        data.setUpdateWhatWeDoExplanation(Collections.singletonList(String.join(",",programContent.getUpdateWhatWeDoExplanation())));
        data.setHowWeDo(programContent.getHowWeDo());
        data.setHowWeDoExplanation(Collections.singletonList(String.join(",",programContent.getHowWeDoExplanation())));
        data.setUsage(programContent.getUsage());

        patientCareServicesRepo.save(data);
    }

    public void updateHeartContent(HeartLungsContent hl) {
        PatientCareServices data = new PatientCareServices();
        data.setHeartTitle(hl.getHeartTitle());
        data.setHeartContent(hl.getHeartContent());
        data.setHeartContentExpln(Collections.singletonList(String.join(",",hl.getHeartContentExpln())));
        data.setUsage("heart");
        patientCareServicesRepo.save(data);
    }
    public void updateLungsContent(HeartLungsContent hl) {
        PatientCareServices data = new PatientCareServices();

        data.setLungsTitle(hl.getLungsTitle());
        data.setLungsContent(hl.getLungsContent());
        data.setLungsContentExpln(Collections.singletonList(String.join("," , hl.getLungsContentExpln())));
        data.setUsage("lungs");
        patientCareServicesRepo.save(data);
    }
}
