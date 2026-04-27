package com.example.healthcare.Mapper;




import com.example.healthcare.DTO.DossierMedicalDTO;
import com.example.healthcare.model.DossierMedical;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface DossierMedicalMapper {
    DossierMedical toEntity(DossierMedicalDTO dossierMedicalDTO);
    DossierMedicalDTO toDTO(DossierMedical dossierMedical );
    List<DossierMedicalDTO> toList(List<DossierMedical> dossierMedicals);
}