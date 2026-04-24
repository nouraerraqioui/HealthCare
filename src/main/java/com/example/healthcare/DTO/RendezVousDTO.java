package com.example.healthcare.DTO;

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
}
