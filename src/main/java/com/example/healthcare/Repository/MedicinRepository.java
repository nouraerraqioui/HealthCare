package com.example.healthcare.Repository;

import com.example.healthcare.model.Medicin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicinRepository extends JpaRepository<Medicin,Long> {
}
