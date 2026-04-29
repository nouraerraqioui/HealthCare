package com.example.healthcare.Mapper;

import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.model.Patient;
import org.hibernate.sql.Update;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.lang.annotation.Target;
import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface PatientMapper {
    Patient toEntity(PatientDTO patientDTO);
    PatientDTO toDTO(Patient patient);
    List<PatientDTO> toListDTO(List<Patient> patients );

    @Mapping( target = "id", ignore = true)
    Patient updateEntityfromDto(PatientDTO patientDTO, @MappingTarget Patient patient);
}
