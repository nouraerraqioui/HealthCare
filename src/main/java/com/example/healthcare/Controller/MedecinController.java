package com.example.healthcare.Controller;

import com.example.healthcare.DTO.MedecinDTO;
import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.Service.MedecinService;
import com.example.healthcare.Service.PatientService;
import com.example.healthcare.model.Medecin;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
    @RestController
    @RequestMapping("/api/medecins")
    public class MedecinController {
        final private MedecinService medecinService;

        @PostMapping()
        @PreAuthorize("hasRole('ADMIN')")
        public void AjouterMedecin(@RequestBody MedecinDTO medecinDTO){
            medecinService.AjouterMedecin(medecinDTO);
        }
        @PutMapping("/{id}")
        @PreAuthorize("hasRole('ADMIN')")
        public void ModifierMedecin(@PathVariable Long id,@RequestBody MedecinDTO medecinDTO){
          medecinService.ModifierMedecin(id,medecinDTO);
        }
        @DeleteMapping("/{id}")
        @PreAuthorize("hasRole('ADMIN')")
        public void SupprimerMedecin(@PathVariable Long id){
           medecinService.SupprimerMedecin(id);
        }
        @GetMapping
        @PreAuthorize("hasRole('ADMIN')")
        public Page<MedecinDTO> ListerMedecins(Pageable pageable){
            return medecinService.ListerMedecins(pageable);
        }

    @GetMapping("/recherche")
    @PreAuthorize("hasRole('ADMIN')")
    public Page<MedecinDTO> ChercherParSpecialite(@RequestParam String specialite,
                                               Pageable pageable) {
            return medecinService.ChercherparSpecialite(specialite, pageable);
    }
    }


