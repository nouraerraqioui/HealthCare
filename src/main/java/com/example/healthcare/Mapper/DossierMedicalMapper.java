package com.example.healthcare.Mapper;




import com.example.healthcare.DTO.DossierMedicalDTO;
import com.example.healthcare.model.DossierMedical;

import java.util.List;

public interface DossierMedicalMapper {
    DossierMedical toEntity(DossierMedicalDTO dossierMedicalDTO);
    DossierMedicalDTO toDTO(DossierMedical dossierMedical );
    List<DossierMedicalDTO> toList(List<DossierMedical> dossierMedicals);
}