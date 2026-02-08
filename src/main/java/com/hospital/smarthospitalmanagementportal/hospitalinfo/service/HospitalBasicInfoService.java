package com.hospital.smarthospitalmanagementportal.hospitalinfo.service;

import com.hospital.smarthospitalmanagementportal.hospitalinfo.repo.HospitalBasicInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalBasicInfoService {
    @Autowired
    HospitalBasicInfoRepo hospitalBasicInfoRepo;
    public List getInfo() {
       List list =  hospitalBasicInfoRepo.findAll();
       if(!list.isEmpty())
        return list;
       else
           return null;
    }
}
