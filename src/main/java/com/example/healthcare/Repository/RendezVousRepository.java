package com.example.healthcare.Repository;

import com.example.healthcare.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
    RendezVous findByPatient_Id(Long id);
    RendezVous findByMedecin_Id(Long id);
}
