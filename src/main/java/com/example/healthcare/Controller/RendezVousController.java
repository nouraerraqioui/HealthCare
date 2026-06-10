package com.example.healthcare.Controller;

import com.example.healthcare.DTO.RendezVousDTO;
import com.example.healthcare.Service.RendezVousService;
import com.example.healthcare.model.RendezVous;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/rendezVous")
public class RendezVousController {
    final private RendezVousService rendezVousService;

    @PostMapping
    @PreAuthorize("hasRole('PATIENT')")
    public RendezVousDTO CreeRendezVous(@RequestBody RendezVousDTO rendezVousDTO) {
        return rendezVousService.AjouterRendezVous(rendezVousDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MEDECIN')")
    public void ModifierRendezVous(@PathVariable Long id, @RequestBody RendezVousDTO rendezVousDTO) {
        rendezVousService.ModifierRendezVous(id, rendezVousDTO);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Page<RendezVous> ListerRendezVous(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "5") int size,
                                             @RequestParam(defaultValue = "date") String sortBy) {

        return rendezVousService.ListerRendezVous(page, size, sortBy);
    }
    @PreAuthorize("hasAnyRole('ADMIN','MEDECIN')")
    @GetMapping("/medecin/{idMedecin}")
    public RendezVousDTO ChercherParMedicin(@PathVariable Long idMedecin) {
        return rendezVousService.ChercherParMedecin(idMedecin);
    }

    @GetMapping("/patient/{idPatient}")
    @PreAuthorize("hasRole('ADMIN')")
    public RendezVousDTO ChercherParPatient(@PathVariable Long idPatient) {
        return rendezVousService.ChercherParPatient(idPatient);
    }

    @GetMapping("/recherche")
    @PreAuthorize("hasAnyRole('ADMIN', 'MEDECIN')")
    public Page<RendezVous> ChercherParStatut(@RequestParam String statut,
                                              Pageable pageable ) {
        return rendezVousService.ChercherParStatut(statut, pageable);
    }
}