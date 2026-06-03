package com.example.healthcare.Repository;

import com.example.healthcare.model.Patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findByNom(String nom, Pageable pageable);
}
