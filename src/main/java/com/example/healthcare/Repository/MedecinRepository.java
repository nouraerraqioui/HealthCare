package com.example.healthcare.Repository;

import com.example.healthcare.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
