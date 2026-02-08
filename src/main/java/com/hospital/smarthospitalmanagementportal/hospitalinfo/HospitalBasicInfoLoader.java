package com.hospital.smarthospitalmanagementportal.hospitalinfo;

import com.hospital.smarthospitalmanagementportal.hospitalinfo.model.HospitalBasicInfo;
import com.hospital.smarthospitalmanagementportal.hospitalinfo.repo.HospitalBasicInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HospitalBasicInfoLoader implements CommandLineRunner {
    @Autowired
    HospitalBasicInfoRepo repo ;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Count...." + repo.count());
        if(repo.count() == 0){
            HospitalBasicInfo newInfo = new HospitalBasicInfo();
            newInfo.setTitle("Smart Hospital Management Portal");
            newInfo.setYear(2026);
            newInfo.setPhoneNo(1234567890L);
            Map<String , String> info = new HashMap<>();
            info.put("privacypolicy","Privacy Policy");
            info.put("terms","Terms");
            info.put("contact","Contact");
            newInfo.setFooterInfo(info);
            repo.save(newInfo);
        }
    }
}
