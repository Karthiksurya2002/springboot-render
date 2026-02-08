package com.hospital.smarthospitalmanagementportal.admin.imageupload.repo;

import com.hospital.smarthospitalmanagementportal.admin.imageupload.model.ImageMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepo extends JpaRepository<ImageMetaData,Long> {

   // ImageMetaData find();
   ImageMetaData findTopByUsageOrderByIdDesc(String usage);
    List<ImageMetaData> findTop5ByUsageOrderByIdDesc(String usage);
    ImageMetaData findByDoctorImageId(int id);

    void deleteByDoctorImageId(Long id);

    ImageMetaData findTopByDoctorImageIdOrderByIdDesc(int usage);

    void deleteAllByDoctorImageId(Long id);
}
