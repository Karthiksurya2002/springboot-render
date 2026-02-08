package com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.repo;

import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.bookappointment.model.BookAppointment;
import com.hospital.smarthospitalmanagementportal.admin.patientcareservice.model.PatientCareServices;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.query.Param;

@Repository
public interface BookAppointmentRepo extends JpaRepository<BookAppointment,Long> {
    BookAppointment findTopByUsageOrderByIdDesc(String usage);
    //BookAppointment findAllByUsage(String usage);
    List<BookAppointment> findAllByUsage(String usage);

    List<BookAppointment> findAllByUsageAndAdSpecialties(String allSpecialtiesDoctor, String specialty);

    List<BookAppointment> findAllByUsageAndAdSpecialtiesAndAdDoctorNameContainingIgnoreCase(String allSpecialtiesDoctor, String specialty, String searchName);

    List<BookAppointment> findAllByUsageAndAdDoctorNameContainingIgnoreCase(String allSpecialty, String searchName);

    List<BookAppointment> findAllByUsageAndAdSpecialtiesIgnoreCase(String allSpecialtiesDoctor, String specialty);

    List<BookAppointment> findAllByUsageAndAdSpecialtiesIgnoreCaseAndAdDoctorNameContainingIgnoreCase(String allSpecialtiesDoctor, String specialty, String searchName);

    List<BookAppointment> findByAppointmentUserId(Long id);

    List<BookAppointment> findByAppointmentBookedBy(String bookedByUser);
    @Transactional
    void deleteByOpNumber(String id);

    BookAppointment findByOpNumber(String op);

    List<BookAppointment> findByAppointmentUserIdOrderByAppointmentCreatedAtAsc(Long id);

    List<BookAppointment> findByAppointmentBookedByOrderByAppointmentCreatedAtAsc(String bookedByUser);

    BookAppointment findByAdUsername(String userName);

    BookAppointment findByAdUsernameIgnoreCase(String trim);

    BookAppointment findById(Optional<BookAppointment> byId);

    List<BookAppointment> findByAppointmentDoctorId(Long doctorId);
    List<BookAppointment> findAllByUsageAndAdShiftIgnoreCase(
            String usage,
            String adShift
    );

    List<BookAppointment> findAllByUsageAndAdShiftIgnoreCaseAndAdDoctorNameContainingIgnoreCase(
            String usage,
            String adShift,
            String adDoctorName
    );

    List<BookAppointment> findAllByUsageAndAdSpecialtiesIgnoreCaseAndAdShiftIgnoreCase(
            String usage,
            String specialty,
            String adShift
    );

    List<BookAppointment> findAllByUsageAndAdSpecialtiesIgnoreCaseAndAdShiftIgnoreCaseAndAdDoctorNameContainingIgnoreCase(
            String usage,
            String specialty,
            String adShift,
            String adDoctorName
    );

    int countByAppointmentDoctorIdAndPatientPreferredDateAndSelectedSlot(
            Long appointmentDoctorId,
            LocalDate patientPreferredDate,
            String selectedSlot
    );

    @Query("""
        SELECT COUNT(b)
        FROM BookAppointment b
        WHERE b.appointmentCreatedAt BETWEEN :start AND :end
    """)
    long appointmentsToday(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );


    @Query("""
        SELECT COUNT(b)
        FROM BookAppointment b
        WHERE b.appointmentCreatedAt BETWEEN :start AND :end
        AND b.selectedSlot IS NOT NULL
    """)
    long bookedSlotsToday(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );


    @Query("""
        SELECT COUNT(b)
        FROM BookAppointment b
        WHERE b.appointmentCreatedAt BETWEEN :start AND :end
        AND b.selectedSlot IS NULL
    """)
    long availableSlotsToday(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );


    @Query("""
        SELECT COUNT(b)
        FROM BookAppointment b
        WHERE b.appointmentCreatedAt BETWEEN :start AND :end
        AND b.appointmentStatus IN (
            'Cancelled_Before_Approved',
            'Cancelled_After_Approved',
            'Rescheduled'
        )
    """)
    long cancelledOrRescheduledToday(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    @Query("""
        SELECT COUNT(b)
        FROM BookAppointment b
        WHERE b.appointmentStatus = 'Cancelled_After_Approved'
        AND b.selectedSlot IS NULL
    """)
    long reusedSlots();


    @Query("""
        SELECT b.appointmentCreatedAt, b.onRescheduleDate
        FROM BookAppointment b
        WHERE b.onRescheduleDate IS NOT NULL
    """)
    List<Object[]> fetchApprovalTimes();




    long countByAppointmentUserId(Long userId);


    @Query("""
        SELECT COUNT(b)
        FROM BookAppointment b
        WHERE b.appointmentUserId = :userId
        AND b.appointmentCreatedAt BETWEEN :start AND :end
    """)
    long countBookedToday(
            @Param("userId") Long userId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );


    long countByAppointmentUserIdAndAppointmentStatusIn(
            Long userId,
            List<String> statuses
    );


    long countByAppointmentUserIdAndAppointmentStatus(
            Long userId,
            String status
    );


    long countByAppointmentDoctorId(Long doctorId);



    long countByAppointmentDoctorIdAndAppointmentStatus(
            Long doctorId,
            String status
    );


    long countByAppointmentDoctorIdAndAppointmentStatusIn(
            Long doctorId,
            List<String> statuses
    );


    @Query("""
        SELECT COUNT(b)
        FROM BookAppointment b
        WHERE b.appointmentDoctorId = :doctorId
        AND b.appointmentCreatedAt BETWEEN :start AND :end
    """)
    long countDoctorRequestsToday(
            @Param("doctorId") Long doctorId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    long count();

    long countByAppointmentStatus(String status);

    long countByAppointmentStatusIn(List<String> statuses);

    @Query("""
        SELECT COUNT(b)
        FROM BookAppointment b
        WHERE b.appointmentCreatedAt BETWEEN :start AND :end
    """)
    long countAppointmentsToday(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );


    @Query("""
        SELECT COUNT(DISTINCT b.appointmentUserId)
        FROM BookAppointment b
    """)
    long countTotalPatients();

    @Query("""
        SELECT COUNT(DISTINCT b.appointmentUserId)
        FROM BookAppointment b
        WHERE b.appointmentCreatedAt BETWEEN :start AND :end
    """)
    long countNewPatientsToday(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    @Query("""
        SELECT COUNT(DISTINCT b.appointmentUserId)
        FROM BookAppointment b
        GROUP BY b.appointmentUserId
        HAVING COUNT(b.id) > 1
    """)
    List<Long> repeatPatients();


    @Query("""
        SELECT COUNT(DISTINCT b.appointmentDoctorId)
        FROM BookAppointment b
    """)
    long countDoctorsWithAppointments();

    @Query("""
        SELECT COUNT(DISTINCT b.appointmentDoctorId)
        FROM BookAppointment b
        WHERE b.appointmentCreatedAt BETWEEN :start AND :end
    """)
    long countDoctorsWithAppointmentsToday(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );


   // long countByAppointmentStatus(String status);

    long countByAppointmentStatusAndSelectedSlotIsNull(
            String status
    );
    @Query("""
    SELECT b
    FROM BookAppointment b
    WHERE b.appointmentStatus IN ('Pending', 'Approved','Rescheduled')
    AND b.patientPreferredDate <= :today
""")
    List<BookAppointment> findForNoShowCheck(
            @Param("today") LocalDate today
    );

    List<BookAppointment> findAllByOrderByAppointmentCreatedAtAsc();


    List<BookAppointment> findAllByAppointmentStatusOrderByAppointmentCreatedAtAsc(String completed);

    List<BookAppointment> findByAppointmentUserIdAndAppointmentStatus(Long id, String completed);
}
