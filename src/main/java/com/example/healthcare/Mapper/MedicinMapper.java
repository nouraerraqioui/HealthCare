package com.example.healthcare.Mapper;

import com.example.healthcare.DTO.MedicinDTO;
import com.example.healthcare.model.Medicin;

import java.util.List;

public interface MedicinMapper {
    Medicin toEntity(MedicinDTO medicinDTO);
    MedicinDTO toDTO(Medicin medicin);
    List<MedicinDTO> toList(List<Medicin> medicins);
}
