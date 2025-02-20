package com.diabetes.diabetes.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/patient")
public class PatientController {


    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping
    public List<Patient> getPatients( @RequestParam(required = false ) Long id,
                                      @RequestParam(required = false ) Integer outcome ,
                                      @RequestParam(required = false ) Integer  age ){

        if (id != null ) {
            return patientService.getPatientsById(id);
        }
        else if (outcome!= null ) {
            return patientService.getPatientsByOutcome(outcome);
        }
        else if (age != null ) {
            return patientService.getPatientsByAge(age);
        }
       else {
           return patientService.getPatients();
       }
    }
    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient ) {
        Patient createdPlayer = patientService.addPatient(patient);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<String> deletePatientById (@PathVariable Long patientId) {
        patientService.deletePatientById(patientId);
        return new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
    }


    @PutMapping(path= "{patientId}")
    public void updatePatient (@PathVariable("patientId") Long patientId ,
                               @RequestParam(required = false) Integer age ,
                               @RequestParam(required = false) Integer outcome,
                               @RequestParam(required = false) Integer bmi) {
        patientService.updatePatient(patientId, age, outcome, bmi );
    }

}