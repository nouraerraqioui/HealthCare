package com.example.healthcare.Mapper;




import com.example.healthcare.DTO.DossierMedicalDTO;
import com.example.healthcare.model.DossierMedical;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")

public interface DossierMedicalMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patient", ignore = true)
    DossierMedical toEntity(DossierMedicalDTO dossierMedicalDTO);

    @Mapping(source = "patient.id", target = "patientId")

    DossierMedicalDTO toDTO(DossierMedical dossierMedical );
    List<DossierMedicalDTO> toList(List<DossierMedical> dossierMedicals);
}