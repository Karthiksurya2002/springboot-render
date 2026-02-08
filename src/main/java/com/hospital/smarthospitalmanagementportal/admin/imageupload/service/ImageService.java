package com.hospital.smarthospitalmanagementportal.admin.imageupload.service;

import com.hospital.smarthospitalmanagementportal.admin.imageupload.model.ImageMetaData;
import com.hospital.smarthospitalmanagementportal.admin.imageupload.model.dto.ImageBytesDto;
import com.hospital.smarthospitalmanagementportal.admin.imageupload.repo.ImageRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepo imageRepo;
    public void saveImage(String fileName, MultipartFile image ,String usage) {
        try {
            LocalDateTime uploadedAt = LocalDateTime.now();
            Path uploadDir = Paths.get("uploads/images");
            Files.createDirectories(uploadDir);

            // 2. generate file name
            String storedFileName =
                    System.currentTimeMillis() + "_" + image.getOriginalFilename();

            Path filePath = uploadDir.resolve(storedFileName);

            // 3. save image to disk
            Files.write(filePath, image.getBytes());

            // 4. save metadata to DB (IMPORTANT)
            ImageMetaData meta = new ImageMetaData();
            meta.setFileName(fileName);
            meta.setEntityType("Admin");
            meta.setFileSize(image.getSize());
            meta.setFilePath(filePath.toString());
            meta.setContentType(image.getContentType());
            meta.setUploadedBy("Admin");
            meta.setUsage(usage);
            meta.setUploadedAt( uploadedAt);

            imageRepo.save(meta);

        } catch (Exception e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }
    public ImageMetaData getLatestImage(String usage) {
        ImageMetaData image = imageRepo.findTopByUsageOrderByIdDesc(usage);

        if (image == null) {
            throw new RuntimeException("No image found");
        }

        return image;
    }

    public void saveImagePatientCare(String fileName, MultipartFile image) {
        try {
            LocalDateTime uploadedAt = LocalDateTime.now();

            Path uploadDir = Paths.get("uploads/patientcare");
            Files.createDirectories(uploadDir);


            String storedFileName =
                    System.currentTimeMillis() + "_" + image.getOriginalFilename();

            Path filePath = uploadDir.resolve(storedFileName);

            Files.write(filePath, image.getBytes());
            ImageMetaData meta = new ImageMetaData();
            meta.setFileName(fileName);
            meta.setEntityType("Admin");
            meta.setFileSize(image.getSize());
            meta.setFilePath(filePath.toString());
            meta.setContentType(image.getContentType());
            meta.setUploadedBy("Admin");
            meta.setUsage("PatientCare");
            meta.setUploadedAt(uploadedAt);

            imageRepo.save(meta);

        } catch (Exception e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }
    public List<ImageMetaData> getLastPatientCareImage() {
        return imageRepo.findTop5ByUsageOrderByIdDesc("PatientCare");
    }
    public List<ImageBytesDto> getLastFiveImagesAsBytes() {

        List<ImageMetaData> images =
                imageRepo.findTop5ByUsageOrderByIdDesc("PatientCare");

        List<ImageBytesDto> result = new ArrayList<>();

        for (ImageMetaData image : images) {
            try {
                Path path = Paths.get(image.getFilePath());
                byte[] bytes = Files.readAllBytes(path);

                String base64 = Base64.getEncoder().encodeToString(bytes);

                ImageBytesDto dto = new ImageBytesDto();
                dto.setBase64(base64);

                String contentType = image.getContentType();
                if (contentType == null || !contentType.contains("/")) {
                    contentType = MediaType.IMAGE_PNG_VALUE;
                }
                dto.setContentType(contentType);

                result.add(dto);

            } catch ( IOException e) {
                throw new RuntimeException("Unable to read image", e);
            }
        }

        return result;
    }

    public void saveEditCertificsLogo(String fileName, MultipartFile image) {
        try {
            LocalDateTime uploadedAt = LocalDateTime.now();
            Path uploadDir = Paths.get("uploads/bestCertificsLog");
            Files.createDirectories(uploadDir);

            // 2. generate file name
            String storedFileName =
                    System.currentTimeMillis() + "_" + image.getOriginalFilename();

            Path filePath = uploadDir.resolve(storedFileName);

            // 3. save image to disk
            Files.write(filePath, image.getBytes());

            // 4. save metadata to DB (IMPORTANT)
            ImageMetaData meta = new ImageMetaData();
            meta.setFileName(fileName);
            meta.setEntityType("Admin");
            meta.setFileSize(image.getSize());
            meta.setFilePath(filePath.toString());
            meta.setContentType(image.getContentType());
            meta.setUploadedBy("Admin");
            meta.setUsage("Certifics");
            meta.setUploadedAt( uploadedAt);

            imageRepo.save(meta);

        } catch (Exception e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }

    public ImageMetaData getCertificsLogo() {
        ImageMetaData image = imageRepo.findTopByUsageOrderByIdDesc("Certifics");

        if (image == null) {
            throw new RuntimeException("No image found");
        }

        return image;
    }

    public void editImageFacilities(String fileName, MultipartFile image) {
        try {
            LocalDateTime uploadedAt = LocalDateTime.now();
            Path uploadDir = Paths.get("uploads/bestCertificsLog");
            Files.createDirectories(uploadDir);
            String storedFileName =
                    System.currentTimeMillis() + "_" + image.getOriginalFilename();

            Path filePath = uploadDir.resolve(storedFileName);
            Files.write(filePath, image.getBytes());
            ImageMetaData meta = new ImageMetaData();
            meta.setFileName(fileName);
            meta.setEntityType("Admin");
            meta.setFileSize(image.getSize());
            meta.setFilePath(filePath.toString());
            meta.setContentType(image.getContentType());
            meta.setUploadedBy("Admin");
            meta.setUsage("facilities");
            meta.setUploadedAt( uploadedAt);

            imageRepo.save(meta);

        } catch (Exception e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }
    public ImageMetaData getImageFacilities() {
        ImageMetaData image = imageRepo.findTopByUsageOrderByIdDesc("facilities");

        if (image == null) {
            throw new RuntimeException("No image found");
        }

        return image;
    }


    public void saveDoctorImage(String fileName, MultipartFile image ,String usage , int doctorImageId) {
        try {
            LocalDateTime uploadedAt = LocalDateTime.now();
            Path uploadDir = Paths.get("uploads/images");
            Files.createDirectories(uploadDir);

            // 2. generate file name
            String storedFileName =
                    System.currentTimeMillis() + "_" + image.getOriginalFilename();

            Path filePath = uploadDir.resolve(storedFileName);

            // 3. save image to disk
            Files.write(filePath, image.getBytes());

            // 4. save metadata to DB (IMPORTANT)
            ImageMetaData meta = new ImageMetaData();
            meta.setFileName(fileName);
            meta.setEntityType("Admin");
            meta.setFileSize(image.getSize());
            meta.setFilePath(filePath.toString());
            meta.setContentType(image.getContentType());
            meta.setUploadedBy("Admin");
            meta.setUsage(usage);
           meta.setDoctorImageId(doctorImageId);
            meta.setUploadedAt( uploadedAt);

            imageRepo.save(meta);

        } catch (Exception e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }

    public ImageMetaData getDoctorImage(int usage) {
        //ImageMetaData image = imageRepo.findByDoctorImageId(usage);
        ImageMetaData image = imageRepo.findTopByDoctorImageIdOrderByIdDesc(usage);


//        if (image == null) {
//            throw new RuntimeException("No image found");
//        }

        return image;
    }

    public void updateDoctorImageById(String fileName, MultipartFile image, String usage, Integer doctorImageId, Boolean imageChanged) throws IOException {
        ImageMetaData meta = imageRepo.findTopByDoctorImageIdOrderByIdDesc(doctorImageId);
        if(imageChanged) {
            ImageMetaData metaa = new ImageMetaData();
            LocalDateTime uploadedAt = LocalDateTime.now();
            Path uploadDir = Paths.get("uploads/images");
            Files.createDirectories(uploadDir);

            // 2. generate file name
            String storedFileName =
                    System.currentTimeMillis() + "_" + image.getOriginalFilename();

            Path filePath = uploadDir.resolve(storedFileName);

            // 3. save image to disk
            Files.write(filePath, image.getBytes());
            metaa.setFileName(fileName);
            metaa.setEntityType("Admin");
            metaa.setFileSize(image.getSize());
            metaa.setFilePath(filePath.toString());
            metaa.setContentType(image.getContentType());
            metaa.setUploadedBy("Admin");
            metaa.setUsage(usage);
            metaa.setDoctorImageId(doctorImageId);
            metaa.setUploadedAt(uploadedAt);

            imageRepo.save(metaa);
        }else{
            imageRepo.save(meta);
        }

    }

    @Transactional
    public void deleteImgageById(Long id) {
        //imageRepo.deleteByDoctorImageId(id);
        imageRepo.deleteAllByDoctorImageId(id);

    }
}

