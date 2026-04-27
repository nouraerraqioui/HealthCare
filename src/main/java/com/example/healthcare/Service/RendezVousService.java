package com.example.healthcare.Service;

import com.example.healthcare.DTO.RendezVousDTO;
import com.example.healthcare.Mapper.RendezVousMapper;
import com.example.healthcare.Repository.MedecinRepository;
import com.example.healthcare.Repository.PatientRepository;
import com.example.healthcare.Repository.RendezVousRepository;
import com.example.healthcare.model.Medecin;
import com.example.healthcare.model.Patient;
import com.example.healthcare.model.RendezVous;
import org.springframework.stereotype.Service;

@Service
public class RendezVousService {
    final private RendezVousRepository rendezVousRepository;
    final private PatientRepository patientRepository;
    final private MedecinRepository medecinRepository;
    final private RendezVousMapper rendezVousMapper;


    public RendezVousService(RendezVousRepository rendezVousRepository, PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousMapper rendezVousMapper) {
        this.rendezVousRepository = rendezVousRepository;
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousMapper = rendezVousMapper;
    }
    public RendezVousDTO AjouterRendezVous(RendezVousDTO rendezVousDTO){
        Patient patient=patientRepository.findById(rendezVousDTO.getIdcPatient()).orElseThrow(()->new RuntimeException("patient n'exist pas"));
        Medecin medecin = medecinRepository.findById(rendezVousDTO.getIdMedecin()).orElseThrow(()->new RuntimeException("medecin'exist pas"));
        RendezVous rendezVous=rendezVousMapper.toEntity(rendezVousDTO);
        rendezVous.setPatient(patient);
        rendezVous.setMedecin(medecin);
        return rendezVousMapper.toDTO(rendezVous);
    }
}
