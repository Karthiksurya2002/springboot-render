package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.repo;

import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.BookAppointmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepo
        extends JpaRepository<BookAppointmentHistory, Long> {

    List<BookAppointmentHistory> findByOpNumberOrderByCreatedAtAsc(String opNumber);
}
