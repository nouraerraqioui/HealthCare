package com.example.healthcare.model;

import jakarta.persistence.Id;

import java.time.LocalDateTime;

public class RendezVous {
    @Id
   private Long id;
    private LocalDateTime dateRendezVous;
    private String statut;

}
