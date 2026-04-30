package com.example.healthcare.Service;

import com.example.healthcare.DTO.DossierMedicalDTO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DossierMedicalServiceTest {

    @Test
    void creeDossierMedical() {
        DossierMedicalDTO dossierMedicalDTO=new DossierMedicalDTO();
    }
}