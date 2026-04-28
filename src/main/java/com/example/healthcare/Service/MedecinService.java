package com.example.healthcare.Service;

import com.example.healthcare.DTO.MedecinDTO;
import com.example.healthcare.Mapper.MedecinMapper;
import com.example.healthcare.Repository.MedecinRepository;
import com.example.healthcare.model.Medecin;
import com.example.healthcare.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<MedecinDTO> ListerAll(){
      return medecinMapper.toList( medecinRepository.findAll());
    }

}
