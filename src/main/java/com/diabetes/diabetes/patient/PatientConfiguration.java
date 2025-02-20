package com.diabetes.diabetes.patient;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PatientConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository repository) {
         return args -> {
             Patient p9 = new Patient(9L,2,197,70,45,543,30,0.158F,53,1);
             Patient p10 = new Patient(10L, 8,125,96,0,0,0,0.232F,54,1);
         repository.saveAll(List.of(p9,p10));
         } ;
    }


}
