package com.example.healthcare.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MedecinDTO {
        private Long id;

        @NotBlank(message = "Le nom est obligatoire")
        private String nom;
        @NotBlank(message = "La spécialité est obligatoire")
        private String specialite;

        @Email(message = "Email invalide")
        private String email;
        @NotBlank(message = "Le téléphone est obligatoire")
        @Size(min = 10, max = 10, message = "Le numéro doit contenir 10 chiffres")
        private String telephone;
    }


