package com.example.healthcare.Service;

import com.example.healthcare.DTO.RendezVousDTO;
import com.example.healthcare.Mapper.RendezVousMapper;
import com.example.healthcare.Repository.MedecinRepository;
import com.example.healthcare.Repository.PatientRepository;
import com.example.healthcare.Repository.RendezVousRepository;
import com.example.healthcare.model.Medecin;
import com.example.healthcare.model.Patient;
import com.example.healthcare.model.RendezVous;
import jakarta.transaction.Transaction;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class RendezVousService {
    final private RendezVousRepository rendezVousRepository;
    final private PatientRepository patientRepository;
    final private MedecinRepository medecinRepository;
    final private RendezVousMapper rendezVousMapper;


    public RendezVousDTO AjouterRendezVous( RendezVousDTO rendezVousDTO){
        Patient patient=patientRepository.findById(rendezVousDTO.getIdPatient()).orElseThrow(()->new RuntimeException("patient n'exist pas"));
        Medecin medecin = medecinRepository.findById(rendezVousDTO.getIdMedecin()).orElseThrow(()->new RuntimeException("medecin'exist pas"));
        RendezVous rendezVous=rendezVousMapper.toEntity(rendezVousDTO);
        rendezVous.setPatient(patient);
        rendezVous.setMedecin(medecin);
        rendezVous.setStatut("EN_ATTENTE");
        return rendezVousMapper.toDTO(rendezVousRepository.save(rendezVous));
    }
    public RendezVousDTO ModifierRendezVous(Long id,RendezVousDTO rendezVousDTO){
        RendezVous rendezVous=rendezVousRepository.findById(id).orElseThrow(()->new RuntimeException("rendez vous n'existe pas"+id));
        rendezVousMapper.updateEntityfromDto(rendezVousDTO,rendezVous);
       return  rendezVousMapper.toDTO(rendezVousRepository.save(rendezVous));
    }
    public RendezVous AnnulerRenderVous(Long id){
      RendezVous rendezVous=  rendezVousRepository.findById(id).orElseThrow(()->new RuntimeException("rendez vous n'existe pas"+id));
        rendezVous.setStatut("ANNULE");
        return rendezVousRepository.save(rendezVous);
    }
    public List<RendezVousDTO> ListerRendezVous(){
      return rendezVousMapper.toListDTO(rendezVousRepository.findAll());
    }
    public RendezVousDTO ChercherParPatient(Long id){
       return rendezVousMapper.toDTO( rendezVousRepository.findByPatient_Id(id));
    }
    public RendezVousDTO ChercherParMedicin(Long id){
        return rendezVousMapper.toDTO( rendezVousRepository.findByMedecin_Id(id));
    }
}
