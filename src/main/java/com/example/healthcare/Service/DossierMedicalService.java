package com.example.healthcare.Service;

import com.example.healthcare.DTO.DossierMedicalDTO;
import com.example.healthcare.Mapper.DossierMedicalMapper;
import com.example.healthcare.Repository.DossierMedicalRepository;
import com.example.healthcare.Repository.PatientRepository;
import com.example.healthcare.model.DossierMedical;
import com.example.healthcare.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class DossierMedicalService {
    final private DossierMedicalRepository dossierMedicalRepository;
    final private DossierMedicalMapper dossierMedicalMapper;
    final private PatientRepository patientRepository   ;


    public DossierMedicalDTO CreeDossierMedical(DossierMedicalDTO dossierMedicalDTO){
          Patient patient=patientRepository.findById(dossierMedicalDTO.getPatientId()).orElseThrow(()->new RuntimeException("patient n'existe pas"));
          DossierMedical dossierMedical=  dossierMedicalMapper.toEntity(dossierMedicalDTO);
          dossierMedical.setPatient(patient);
         return dossierMedicalMapper.toDTO(dossierMedicalRepository.save(dossierMedical));
    }
    public DossierMedicalDTO AjouterDiagnostic(Long id,String diagnostic){
        DossierMedical dossier = dossierMedicalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dossier n'existe pas "));

        dossier.setDiagnostic(diagnostic);

        return dossierMedicalMapper.toDTO(dossierMedicalRepository.save(dossier));
    }
    public DossierMedicalDTO AjouterObservation(Long id,String observation){
        DossierMedical dossier = dossierMedicalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dossier n'existe pas"));

        dossier.setObservations(observation);

        return dossierMedicalMapper.toDTO(dossierMedicalRepository.save(dossier));
    }
    public DossierMedicalDTO ConsulterDossier(Long id){
        DossierMedical dossier = dossierMedicalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dossier n'existe pas "));
        return dossierMedicalMapper.toDTO(dossier);

    }
    public Page<DossierMedicalDTO> ListerDossiers(Pageable pageable) {
        Page<DossierMedical> dossierMedicals= dossierMedicalRepository.findAll(pageable);
        return dossierMedicals.map(dossierMedicalMapper::toDTO);
    }
    public Page<DossierMedicalDTO> chercherParDiagnostic(String diagnostic,Pageable pageable){
        Page<DossierMedical> d=dossierMedicalRepository.findByDiagnosticContainingIgnoreCase(diagnostic,pageable);
        return d.map(dossierMedicalMapper::toDTO);
    }
}

