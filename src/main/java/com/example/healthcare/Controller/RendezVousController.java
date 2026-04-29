package com.example.healthcare.Controller;

import com.example.healthcare.DTO.RendezVousDTO;
import com.example.healthcare.Service.RendezVousService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/rendezVous")
public class RendezVousController {
    final private RendezVousService rendezVousService;

    @PostMapping
    public RendezVousDTO CreeRendezVous(@RequestBody RendezVousDTO rendezVousDTO){
        return rendezVousService.AjouterRendezVous(rendezVousDTO);
    }
    @PutMapping("/{id}")
    public void ModifierRendezVous(@PathVariable Long id,@RequestBody RendezVousDTO rendezVousDTO){
        rendezVousService.ModifierRendezVous(id, rendezVousDTO);
    }
    @GetMapping
    public List<RendezVousDTO> ListerRendezVous(){
       return  rendezVousService.ListerRendezVous();
    }
    @GetMapping("/medecin/{idMedecin}")
    public RendezVousDTO ChercherParMedicin(@PathVariable Long idMedecin){
        return        rendezVousService.ChercherParMedecin(idMedecin);
    }
    @GetMapping("/patient/{idPatient}")
    public RendezVousDTO ChercherParPatient(@PathVariable Long idPatient){
        return  rendezVousService.ChercherParPatient(idPatient);
    }
}
