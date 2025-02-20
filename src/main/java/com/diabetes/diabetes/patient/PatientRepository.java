package com.diabetes.diabetes.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    void deletePatientById (Long id ) ;

   Optional<Patient> findById (Long patientId ) ;


}
