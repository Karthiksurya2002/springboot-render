package com.hospital.smarthospitalmanagementportal.admin.imageupload.controller;

import com.hospital.smarthospitalmanagementportal.admin.imageupload.model.ImageMetaData;
import com.hospital.smarthospitalmanagementportal.admin.imageupload.model.dto.ImageBytesDto;
import com.hospital.smarthospitalmanagementportal.admin.imageupload.model.dto.ImageResponseDTO;
import com.hospital.smarthospitalmanagementportal.admin.imageupload.service.ImageService;
import com.hospital.smarthospitalmanagementportal.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static java.util.Arrays.stream;

@RestController
@CrossOrigin(
        origins = "http://localhost:4200",
        exposedHeaders = "Cache-Control"
)
@RequestMapping(value ="/shmp/image")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<?> saveImage(@RequestPart("serviceName") String fileName, @RequestPart("image") MultipartFile image,
                                @RequestPart("usage") String usage ) {
        imageService.saveImage(fileName, image , usage);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Image saved successfully.");
        response.setData(null);
        response.setStatus(200);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getdashboardimage")
    public ResponseEntity<byte[]> getLatestImage(@RequestParam("usage") String usage) {
        ImageMetaData image = imageService.getLatestImage(usage);

        String contentType = image.getContentType();


        if (contentType == null || !contentType.contains("/")) {
            contentType = MediaType.IMAGE_PNG_VALUE;
        }

        try {
            Path path = Paths.get(image.getFilePath());
            byte[] imageBytes = Files.readAllBytes(path);

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(imageBytes);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read image", e);
        }
    }
    @PostMapping(
            value = "/editPatient",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<?> updatePatientCare(

            @RequestParam String fieldName1,
            @RequestParam String fieldName2,
            @RequestParam String fieldName3,
            @RequestParam String fieldName4,
            @RequestParam String fieldName5,

            @RequestParam(required = false) List<MultipartFile> images,
            @RequestParam(required = false) List<String> iconNos
    ) {
        if (images != null && iconNos != null) {
            for (int i = 0; i < images.size(); i++) {
                String fileName = "ICON_" + iconNos.get(i);
                imageService.saveImagePatientCare(fileName, images.get(i));
            }
        }
        ApiResponse<ImageMetaData> response = new ApiResponse<>();
        response.setMessage("Patient Care updated successfully");
        response.setStatus(200);
        response.setData(null);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getPatientCareImage")
    public ResponseEntity<List<ImageBytesDto>> getLastFiveImages() {

     List<ImageBytesDto> images =
            imageService.getLastFiveImagesAsBytes();

     return ResponseEntity.ok(images);
    }
    @PostMapping(value="/editCertificsLogo" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<?> saveEditCertificsLogo(@RequestPart("serviceName") String fileName, @RequestPart("image") MultipartFile image) {
        imageService.saveEditCertificsLogo(fileName, image);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Image saved successfully.");
        response.setData(null);
        response.setStatus(200);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getCertificsLogo")
    public ResponseEntity<byte[]> getCertificsLogo() {
        ImageMetaData image = imageService.getCertificsLogo();

        String contentType = image.getContentType();


        if (contentType == null || !contentType.contains("/")) {
            contentType = MediaType.IMAGE_PNG_VALUE;
        }

        try {
            Path path = Paths.get(image.getFilePath());
            byte[] imageBytes = Files.readAllBytes(path);

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(imageBytes);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read image", e);
        }
    }

    @PostMapping(value="/editImageFacilities" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<?> editImageFacilities(@RequestPart("serviceName") String fileName, @RequestPart("image") MultipartFile image) {
        imageService.editImageFacilities(fileName, image);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Image saved successfully.");
        response.setData(null);
        response.setStatus(200);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getImageFacilities")
    public ResponseEntity<byte[]> getImageFacilities() {
        ImageMetaData image = imageService.getImageFacilities();

        String contentType = image.getContentType();


        if (contentType == null || !contentType.contains("/")) {
            contentType = MediaType.IMAGE_PNG_VALUE; // default fallback
        }

        try {
            Path path = Paths.get(image.getFilePath());
            byte[] imageBytes = Files.readAllBytes(path);

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .body(imageBytes);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read image", e);
        }
    }

//@GetMapping("/getDoctorAllImage")
//public ResponseEntity<?> getDoctorImage(
//        @RequestParam List<Integer> id) {
//
//    List<byte[]> listId = new ArrayList<>();
//    for (Integer i : id) {
//        ImageMetaData image = (imageService.getDoctorImage(i));
//        String contentType = image.getContentType();
//        if (contentType == null || !contentType.contains("/")) {
//            contentType = MediaType.IMAGE_PNG_VALUE;
//        }
//
//        try {
//            Path path = Paths.get(image.getFilePath());
//            byte[] imageBytes = Files.readAllBytes(path);
//            listId.add(imageBytes);
//        } catch (IOException e) {
//            throw new RuntimeException("Unable to read image", e);
//        }
//    }
//    return ResponseEntity.ok(listId);
//}
@GetMapping("/getDoctorAllImage")
public ResponseEntity<List<ImageResponseDTO>> getDoctorImage(
        @RequestParam List<Integer> id) {

    List<ImageResponseDTO> responseList = new ArrayList<>();

    for (Integer imageId : id) {

        try {
            ImageMetaData image = imageService.getDoctorImage(imageId);

            // If DB record not found
            if (image == null) {
                responseList.add(
                        new ImageResponseDTO(imageId, null, null, "Image metadata not found")
                );
                continue;
            }

            String contentType = image.getContentType();
            if (contentType == null || !contentType.contains("/")) {
                contentType = MediaType.IMAGE_PNG_VALUE;
            }

            Path path = Paths.get(image.getFilePath());

            // If file path missing or file not exists
            if (image.getFilePath() == null || !Files.exists(path)) {
                responseList.add(
                        new ImageResponseDTO(imageId, contentType, null, "Image file not found")
                );
                continue;
            }

            byte[] imageBytes = Files.readAllBytes(path);
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);

            responseList.add(
                    new ImageResponseDTO(imageId, contentType, base64Image, "SUCCESS")
            );

        } catch (Exception e) {
            // Catch EVERYTHING so loop never breaks
            responseList.add(
                    new ImageResponseDTO(imageId, null, null, "ERROR: " + e.getMessage())
            );
        }
    }

    return ResponseEntity.ok(responseList);
}


    @PostMapping(
            value = "/saveDoctorImage",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<?> saveDoctorImage(
            @RequestParam("serviceName") String fileName,
            @RequestParam("image") MultipartFile image,
            @RequestParam("usage") String usage,
            @RequestParam("doctorImageId") Integer doctorImageId
    ) {
        imageService.saveDoctorImage(fileName, image, usage, doctorImageId);

        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Image saved successfully.");
        response.setData(null);
        response.setStatus(200);

        return ResponseEntity.ok(response);
    }
    @PostMapping(
            value = "/updateDoctorImageById",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<?> updateDoctorImageById(
            @RequestParam("serviceName") String fileName,
            @RequestParam(required = false) MultipartFile image,
            @RequestParam("usage") String usage,
            @RequestParam("doctorImageId") Integer doctorImageId,
            @RequestParam("imageChanged") Boolean imageChanged
    ) throws IOException {
        imageService.updateDoctorImageById(fileName, image, usage, doctorImageId ,imageChanged);

        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Image Updated Successfully.");
        response.setData(null);
        response.setStatus(201);

        return ResponseEntity.ok(response);
    }
    @DeleteMapping(value="/deleteDoctorByIdImage")
    ResponseEntity<?> deleteImgageById(@RequestParam("id") Long id){
        imageService.deleteImgageById(id);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("Image Deleted Successfully.");
        response.setData(null);
        response.setStatus(200);

        return ResponseEntity.ok(response);
    }
}