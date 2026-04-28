package com.example.healthcare.Controller;

import com.example.healthcare.DTO.RendezVousDTO;
import com.example.healthcare.Service.RendezVousService;
import com.example.healthcare.model.RendezVous;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/rendezVous")
public class RendezVousController {
    final private RendezVousService rendezVousService;
    @PostMapping
    public void CreeRendezVous(@RequestBody RendezVousDTO rendezVousDTO){
        rendezVousService.AjouterRendezVous(rendezVousDTO);
    }
    @PutMapping("/{id}")
    public void ModifierRendezVous(@PathVariable Long id,@RequestBody RendezVousDTO rendezVousDTO){
        rendezVousService.ModifierRendezVous(id, rendezVousDTO);
    }
    @GetMapping
    public List<RendezVousDTO> ListerRendezVous(){
       return  rendezVousService.ListerRendezVous();
    }
    @GetMapping("/{idMedecin}")
    public RendezVousDTO ChercherParMedicin(@PathVariable Long idMedecin){
        return        rendezVousService.ChercherParMedicin(idMedecin);
    }
    @GetMapping("/{idPatient}")
    public RendezVousDTO ChercherParPatient(@PathVariable Long idPatient){
        return  rendezVousService.ChercherParMedicin(idPatient);
    }
}
