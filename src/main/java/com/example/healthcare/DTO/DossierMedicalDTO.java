package com.example.healthcare.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DossierMedicalDTO {
    private Long id;
    private String diagnostic;
    private String observations;
    private LocalDateTime dateCreation;
    private Long idPatient;
}
