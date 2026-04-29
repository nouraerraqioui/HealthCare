package com.example.healthcare.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RendezVousDTO {

    private Long id;
    private LocalDateTime dateRendezVous;
    private String statut;
    private Long patientId;
    private Long medecinId;
}
