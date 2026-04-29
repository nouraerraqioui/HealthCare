package com.example.healthcare.Mapper;

import com.example.healthcare.DTO.MedecinDTO;
import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.model.Medecin;
import com.example.healthcare.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface MedecinMapper {
    Medecin toEntity(MedecinDTO medecinDTO);
    MedecinDTO toDTO(Medecin medecin);
    List<MedecinDTO> toList(List<Medecin> medecins);
    @Mapping( target = "id", ignore = true)
    Medecin updateEntityfromDto(MedecinDTO medecinDTO, @MappingTarget Medecin medecin);

}
