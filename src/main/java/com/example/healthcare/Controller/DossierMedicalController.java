package com.example.healthcare.Controller;


import com.example.healthcare.DTO.DossierMedicalDTO;
import com.example.healthcare.Service.DossierMedicalService;
import com.example.healthcare.model.DossierMedical;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @AllArgsConstructor
    @RestController
    @RequestMapping("/api/dossierMedical")
    public class DossierMedicalController {
        final private DossierMedicalService dossierMedicalService;
        @PostMapping
        @PreAuthorize("hasRole('ADMIN')")
        public void CreeDossier(@RequestBody DossierMedicalDTO dossierMedicalDTO){
            dossierMedicalService.CreeDossierMedical (dossierMedicalDTO);
        }
        @PutMapping("/{id}/diagnostic")
        @PreAuthorize("hasRole('MEDECIN')")
        public void AjouterDiagnostic(@PathVariable Long id,@RequestBody String diagnostic){
            dossierMedicalService.AjouterDiagnostic(id,diagnostic);
    }
    @PutMapping("/{id}/observation")
    @PreAuthorize("hasRole('MEDECIN')")
        public  void AjouterObservation(@PathVariable Long id,@RequestBody String observation){
            dossierMedicalService.AjouterObservation(id,observation);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MEDECIN')")
        public DossierMedicalDTO  ConsulterDossier(@PathVariable Long id){
           return dossierMedicalService.ConsulterDossier(id);
    }
        @PreAuthorize("hasAnyRole('ADMIN','MEDECIN')")
        @GetMapping
        public Page<DossierMedicalDTO> ListerDossiers(Pageable pageable) {
            return dossierMedicalService.ListerDossiers(pageable);
        }
        @PreAuthorize("hasRole('ADMIN')")
        @GetMapping("/diag")
        public Page<DossierMedicalDTO> chercherParDiag(@RequestParam String diagnostic ,Pageable pageable){
            return dossierMedicalService.chercherParDiagnostic(diagnostic,pageable);
        }
}
