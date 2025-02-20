package com.diabetes.diabetes.patient;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private final PatientRepository patientRepository ;


    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

   public List<Patient> getPatientsById(Long id) {
        return patientRepository.findAll().stream().
                filter(patient ->
                        patient.getId().equals(id)
                )
                .collect(Collectors.toList());
    }
    public List<Patient> getPatientsByOutcome(Integer outcome ) {
        return patientRepository.findAll().stream().filter
                (patient -> patient.getOutcome().equals(outcome)).
                collect(Collectors.toList());
    }

    public List<Patient> getPatientsByAge(Integer age ) {
        return  patientRepository.findAll().stream().
                filter(patient ->
                    patient.getAge().equals(age)
                ).
                collect(Collectors.toList());
    }

    public Patient addPatient(Patient patient) {
        Optional<Patient> patientById =
                patientRepository.findById(patient.getId());
        if (patientById.isPresent()) {
            throw new IllegalStateException("id already taken");
        }
        patientRepository.save(patient);
        return patient ;
    }

    @Transactional
    public void deletePatientById (Long id ) {
        patientRepository.deletePatientById(id);
    }

    @Transactional
    public void updatePatient (Long patientId , Integer age , Integer outcome  , Integer bmi ) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new IllegalStateException("patient id with " + patientId + " does not exist")
        );
        if (  outcome != null && !Objects.equals(patient.getOutcome(), outcome) ) {
            patient.setOutcome(outcome);
        }
        if ( age!= null &&  !Objects.equals(patient.getAge(), age) ) {
            patient.setAge(age);
        }
        if ( bmi!= null &&  !Objects.equals(patient.getBmi(), bmi) ) {
            patient.setBmi(bmi);
        }
    }

}

