package com.example.healthcare.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PatientDTO {
    private Long id;
    @NotBlank(message = "Le nom est obligatoire")
    private String nom;
    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;
    @Email(message = "Email invalide")
    private String email;
    @NotBlank(message = "Le téléphone est obligatoire")
    @Size(min = 10, max = 10, message = "Le numéro doit contenir 10 chiffres")
    private String telephone;
    @Past(message = "La date de naissance doit être dans le passé")
    private LocalDate dateNaissance;
}
