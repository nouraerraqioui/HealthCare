package com.example.healthcare.Repository;

import com.example.healthcare.model.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical,Long> {
}
