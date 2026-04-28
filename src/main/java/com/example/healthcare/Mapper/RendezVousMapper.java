package com.example.healthcare.Mapper;

import com.example.healthcare.DTO.RendezVousDTO;
import com.example.healthcare.model.RendezVous;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel = "spring")

public interface RendezVousMapper {

    RendezVous toEntity(RendezVousDTO rendezVousDTO);
    RendezVousDTO toDTO(RendezVous rendezVous);

    List<RendezVousDTO> toListDTO(List<RendezVous> rendezVous);

    @Mapping(target = "id",ignore = true)
    RendezVous updateEntityfromDto(RendezVousDTO rendezVousDTO, @MappingTarget RendezVous rendezVous);

}
