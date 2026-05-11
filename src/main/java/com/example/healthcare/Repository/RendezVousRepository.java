package com.example.healthcare.Repository;

import com.example.healthcare.model.Patient;
import com.example.healthcare.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
    RendezVous findByPatient_Id(Long id);
    RendezVous findByMedecin_Id(Long id);
    List<RendezVous> findAllByMedecin_Id(Long id);


}
