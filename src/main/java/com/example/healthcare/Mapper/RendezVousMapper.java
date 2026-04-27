package com.example.healthcare.Mapper;

import com.example.healthcare.DTO.RendezVousDTO;
import com.example.healthcare.model.RendezVous;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RendezVousMapper {
    @Mapping(source = "patient.id", target = "idpatient")
    @Mapping(source = "medecin.id", target = "idmedecin")
    RendezVous toEntity(RendezVousDTO rendezVousDTO);
    RendezVousDTO toDTO(RendezVous rendezVous);
    List<RendezVousDTO> toList(List<RendezVous> rendezVous);
}
