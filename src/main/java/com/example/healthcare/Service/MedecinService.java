package com.example.healthcare.Service;

import com.example.healthcare.DTO.MedecinDTO;
import com.example.healthcare.Mapper.MedecinMapper;
import com.example.healthcare.Repository.MedecinRepository;
import com.example.healthcare.model.Medecin;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
@AllArgsConstructor
@Service
public class MedecinService {
    final private MedecinRepository medecinRepository;
    final private MedecinMapper medecinMapper;

    public MedecinDTO AjouterMedecin(MedecinDTO medecinDTO){
        return medecinMapper.toDTO(medecinRepository.save(medecinMapper.toEntity(medecinDTO)));
    }public MedecinDTO ModifierMedecin(Long id,MedecinDTO medecinDTO){
        Medecin medecin= medecinRepository.findById(id).orElseThrow(()->new RuntimeException("medecin n'exist pas"+id));

        medecinMapper.updateEntityfromDto(medecinDTO,medecin);
        return medecinMapper.toDTO(medecinRepository.save(medecin));
    }
    public void SupprimerMedecin(Long id){
      Medecin medecin= medecinRepository.findById(id).orElseThrow(()->new RuntimeException("medecin n'exist pas"+id));
        medecinRepository.delete(medecin);
    }
    public Page<MedecinDTO> ListerMedecins(Pageable pageable) {
        Page<Medecin>medecins=medecinRepository.findAll(pageable);
        return medecins.map(medecinMapper::toDTO) ;
    }
    public Page<MedecinDTO> ChercherparSpecialite(String specialite,Pageable pageable) {
        Page<Medecin>medecins=medecinRepository.findBySpecialite(specialite, pageable);
        return medecins.map(medecinMapper::toDTO) ;
    }

    }
