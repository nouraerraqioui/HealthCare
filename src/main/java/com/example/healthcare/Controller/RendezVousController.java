package com.example.healthcare.Controller;

import com.example.healthcare.DTO.RendezVousDTO;
import com.example.healthcare.model.RendezVous;

import java.util.List;

public interface RendezVousController {
    RendezVous toEntity(RendezVousDTO rendezVousDTO);
    RendezVousDTO toDTO(RendezVous rendezVous);
    List<RendezVousDTO> toList(List<RendezVous> rendezVous);
}
