package com.example.healthcare.DTO;


import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "La date est obligatoire")
    private LocalDateTime dateRendezVous;

    private String statut;

    @NotNull(message = "L'ID du médecin est obligatoire")
    private Long medecinId;

    @NotNull(message = "L'ID du patient est obligatoire")
    private Long patientId;

}

