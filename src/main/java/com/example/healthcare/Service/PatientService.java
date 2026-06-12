package com.example.healthcare.Service;

import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.Mapper.PatientMapper;
import com.example.healthcare.Repository.PatientRepository;
import com.example.healthcare.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;



@AllArgsConstructor
@Service
public class PatientService {
    final private PatientRepository patientRepository;
    final private PatientMapper patientMapper;

    @CacheEvict(value = "patients", allEntries = true)

    public PatientDTO AjouterPatient(PatientDTO patientDTO){
       return patientMapper.toDTO( patientRepository.save(patientMapper.toEntity(patientDTO)));
    }
    @CacheEvict(value = "patients", allEntries = true)

    public PatientDTO ModifierPatient(Long id,PatientDTO patientDTO){
        Patient patient = patientRepository.findById(id).orElseThrow(()->new RuntimeException("Patient n'exist pas"+ id));
           patientMapper.updateEntityfromDto(patientDTO,patient);
           return patientMapper.toDTO(patientRepository.save(patient));
    }
    @CacheEvict(value = "patients", allEntries = true)
    public void SupprimerPatient(Long id){
        Patient patient= patientRepository.findById(id).orElseThrow(()->new RuntimeException("Patient n'exist pas"+id));
        patientRepository.delete(patient);
    }
    @Cacheable(
            value = "patients",
            key = "#pageable.pageNumber + '-' + #pageable.pageSize + '-' + #pageable.sort"
    )
    public Page<PatientDTO> ListerPatients(Pageable pageable) {
      Page<Patient>patients=  patientRepository.findAll(pageable);
        return patients.map(patientMapper::toDTO);
    }
    @Cacheable(value = "patientsByName", key = "#nom + '-' + #pageable.pageNumber + '-' + #pageable.pageSize")
    public Page<PatientDTO> ConsulterPatient(String nom, Pageable pageable) {
        Page<Patient>patients= patientRepository.findByNom(nom, pageable);
        return patients.map(patientMapper::toDTO);
    }
}
