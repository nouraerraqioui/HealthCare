package com.example.healthcare.Service;

import com.example.healthcare.DTO.MedecinDTO;
import com.example.healthcare.Mapper.MedecinMapper;
import com.example.healthcare.Repository.MedecinRepository;
import com.example.healthcare.model.Medecin;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Request;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @CacheEvict(value = "medecins", allEntries = true)
    public MedecinDTO AjouterMedecin(MedecinDTO medecinDTO){
        return medecinMapper.toDTO(medecinRepository.save(medecinMapper.toEntity(medecinDTO)));
    }

    @CacheEvict(value = "medecins", allEntries = true)
    public MedecinDTO ModifierMedecin(Long id,MedecinDTO medecinDTO){
        Medecin medecin= medecinRepository.findById(id).orElseThrow(()->new RuntimeException("medecin n'exist pas"+id));

        medecinMapper.updateEntityfromDto(medecinDTO,medecin);
        return medecinMapper.toDTO(medecinRepository.save(medecin));
    }
    @CacheEvict(value = "medecins", allEntries = true)

    public void SupprimerMedecin(Long id){
      Medecin medecin= medecinRepository.findById(id).orElseThrow(()->new RuntimeException("medecin n'exist pas"+id));
        medecinRepository.delete(medecin);
    }
    @Cacheable(value = "medecins", key = "#pageable.pageNumber + '-' + #pageable.pageSize + '-' + #pageable.sort")
    public Page<MedecinDTO> ListerMedecins(Pageable pageable) {
        Page<Medecin>medecins=medecinRepository.findAll(pageable);
        return medecins.map(medecinMapper::toDTO) ;
    }
    @Cacheable(value = "medecinsBySpecialite", key = "#specialite + '-' + #pageable.pageNumber + '-' + #pageable.pageSize")
    public Page<MedecinDTO> ChercherparSpecialite(String specialite,Pageable pageable) {
        Page<Medecin>medecins=medecinRepository.findBySpecialite(specialite, pageable);
        return medecins.map(medecinMapper::toDTO) ;
    }

    }
