package com.example.healthcare.Service;

import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.Mapper.PatientMapper;
import com.example.healthcare.Repository.PatientRepository;
import com.example.healthcare.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService {
    final private PatientRepository patientRepository;
    final private PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }
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
    public List<PatientDTO> ListerPatients(){
         return patientMapper.toListDTO(patientRepository.findAll());
    }
public PatientDTO ConsulterPatient(Long id){
      return patientMapper.toDTO( patientRepository.findById(id).orElseThrow(()->new RuntimeException("Patient n'exist pas"+id)));
}

}
