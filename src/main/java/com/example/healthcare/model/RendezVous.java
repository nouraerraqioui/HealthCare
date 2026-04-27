package com.example.healthcare.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    private LocalDateTime dateRendezVous;
    private String statut;
    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
