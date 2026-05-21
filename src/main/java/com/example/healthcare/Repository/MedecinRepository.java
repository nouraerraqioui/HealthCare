package com.example.healthcare.Repository;

import com.example.healthcare.model.Medecin;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Page<Medecin> findBySpecialite(String specialite, Pageable pageable);

    Page<Medecin> findAll(Pageable pageable);
}
