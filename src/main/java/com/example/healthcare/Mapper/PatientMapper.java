package com.example.healthcare.Mapper;

import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface PatientMapper {
    PatientDTO toEntity(Patient patient);
    Patient toDTO(PatientDTO patientDTO);
    List<PatientDTO> toListDTO(List<Patient> patients );
}
