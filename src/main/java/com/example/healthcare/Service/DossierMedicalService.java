package com.example.healthcare.Service;

import com.example.healthcare.DTO.DossierMedicalDTO;
import com.example.healthcare.Mapper.DossierMedicalMapper;
import com.example.healthcare.Repository.DossierMedicalRepository;
import com.example.healthcare.Repository.PatientRepository;
import com.example.healthcare.model.DossierMedical;
import com.example.healthcare.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class DossierMedicalService {
    final private DossierMedicalRepository dossierMedicalRepository;
    final private DossierMedicalMapper dossierMedicalMapper;
    final private PatientRepository patientRepository   ;


    public DossierMedicalDTO CreeDossierMedical(DossierMedicalDTO dossierMedicalDTO){
          Patient patient=patientRepository.findById(dossierMedicalDTO.getIdPatient()).orElseThrow(()->new RuntimeException("patient n'existe pas"));
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

}
