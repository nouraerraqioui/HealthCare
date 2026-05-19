package com.example.healthcare.Repository;

import com.example.healthcare.model.Patient;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findByNomContainingIgnoreCase(String nom, Pageable pageable);
}
