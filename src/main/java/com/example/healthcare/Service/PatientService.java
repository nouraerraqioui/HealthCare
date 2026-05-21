package com.example.healthcare.Service;

import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.Mapper.PatientMapper;
import com.example.healthcare.Repository.PatientRepository;
import com.example.healthcare.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@AllArgsConstructor
@Service
public class PatientService {
    final private PatientRepository patientRepository;
    final private PatientMapper patientMapper;


    public PatientDTO AjouterPatient(PatientDTO patientDTO){
       return patientMapper.toDTO( patientRepository.save(patientMapper.toEntity(patientDTO)));
    }
    public PatientDTO ModifierPatient(Long id,PatientDTO patientDTO){
        Patient patient = patientRepository.findById(id).orElseThrow(()->new RuntimeException("Patient n'exist pas"+ id));
           patientMapper.updateEntityfromDto(patientDTO,patient);
           return patientMapper.toDTO(patientRepository.save(patient));
    }
    public void SupprimerPatient(Long id){
        Patient patient= patientRepository.findById(id).orElseThrow(()->new RuntimeException("Patient n'exist pas"+id));
        patientRepository.delete(patient);
    }
    public Page<Patient> ListerPatients(Pageable pageable){
         return patientRepository.findAll(pageable);
    }
public Page<Patient> ConsulterPatient(String nom, Pageable pageable){
        return  patientRepository.findByNom(nom,pageable);
}

}
