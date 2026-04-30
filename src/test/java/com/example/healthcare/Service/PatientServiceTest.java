package com.example.healthcare.Service;

import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.Repository.PatientRepository;
import com.example.healthcare.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class PatientServiceTest {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;
    @BeforeEach
    void setUp() {
        patientRepository.deleteAll();
    }
    @Test
    void ajouterPatient() {
        PatientDTO patientDTO=new PatientDTO();
        patientDTO.setNom("ali");
        patientDTO.setPrenom("akram");
        patientDTO.setEmail("ali@gmail.com");
        patientDTO.setTelephone("062345678");
        patientDTO.setDateNaissance(LocalDate.of(2004,12,1));
        PatientDTO result= patientService.AjouterPatient(patientDTO);
        assertNotNull(result);
    }

    @Test
    void ModifierPatient() {
        Patient patient=new Patient();
        patient.setNom("otmane");
        patient.setPrenom("gharib");
        patient.setEmail("otmane@gmail.com");
        patient.setTelephone("062345678");
       Patient result= patientRepository.save(patient);

        PatientDTO patientDTO=new PatientDTO();
        patientDTO.setNom("al");
        patientDTO.setPrenom("ikram");
        patientDTO.setEmail("alikram@gmail.com");
        patientDTO.setTelephone("062345678");
        PatientDTO modofie= patientService.ModifierPatient(result.getId(),patientDTO);
        assertEquals(patientDTO,modofie);







    }
}