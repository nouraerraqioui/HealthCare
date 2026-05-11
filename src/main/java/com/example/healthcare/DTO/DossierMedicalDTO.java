package com.example.healthcare.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Le diagnostic est obligatoire")
    private String diagnostic;

    @NotBlank(message = "Les observations sont obligatoires")
    private String observations;

    @NotNull(message = "La date de création est obligatoire")
    private LocalDateTime dateCreation;
    @NotNull(message = "L'ID du patient est obligatoire")
    private Long patientId;
}
