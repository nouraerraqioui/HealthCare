package com.example.healthcare.Service;

import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.Mapper.PatientMapper;
import com.example.healthcare.Repository.PatientRepository;
import com.example.healthcare.model.Patient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientMapper patientMapper;

    @InjectMocks
    private PatientService patientService;

    @Test
    void ajouterPatient() {

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setNom("ali");
        patientDTO.setPrenom("akram");
        patientDTO.setEmail("ali@gmail.com");
        patientDTO.setTelephone("062345678");
        patientDTO.setDateNaissance(LocalDate.of(2004, 12, 1));

        Patient patientEntity = new Patient();
        patientEntity.setNom("ali");
        patientEntity.setPrenom("akram");

        PatientDTO savedDTO = new PatientDTO();
        savedDTO.setNom("ali");
        savedDTO.setPrenom("akram");

        when(patientMapper.toEntity(patientDTO)).thenReturn(patientEntity);
        when(patientRepository.save(patientEntity)).thenReturn(patientEntity);
        when(patientMapper.toDTO(patientEntity)).thenReturn(savedDTO);

        PatientDTO result = patientService.AjouterPatient(patientDTO);

        assertNotNull(result);
        assertEquals("ali", result.getNom());

        verify(patientRepository, times(1)).save(patientEntity);
    }

    @Test
    void modifierPatient() {

        Long id = 1L;

        Patient patientEntity = new Patient();
        patientEntity.setId(id);
        patientEntity.setNom("otmane");

        PatientDTO updateDTO = new PatientDTO();
        updateDTO.setNom("al");
        updateDTO.setPrenom("ikram");
        updateDTO.setEmail("alikram@gmail.com");
        updateDTO.setTelephone("062345678");
        updateDTO.setDateNaissance(LocalDate.of(2000, 1, 1));

        Patient updatedEntity = new Patient();
        updatedEntity.setId(id);
        updatedEntity.setNom("al");

        PatientDTO updatedResultDTO = new PatientDTO();
        updatedResultDTO.setNom("al");

        when(patientRepository.findById(id)).thenReturn(java.util.Optional.of(patientEntity));
        when(patientRepository.save(patientEntity)).thenReturn(updatedEntity);
        when(patientMapper.toDTO(updatedEntity)).thenReturn(updatedResultDTO);

        PatientDTO result = patientService.ModifierPatient(id, updateDTO);

        assertNotNull(result);
        assertEquals("al", result.getNom());

        verify(patientRepository, times(1)).findById(id);
        verify(patientRepository, times(1)).save(patientEntity);
    }
}