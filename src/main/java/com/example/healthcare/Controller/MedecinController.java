package com.example.healthcare.Controller;

import com.example.healthcare.DTO.MedecinDTO;
import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.Service.MedecinService;
import com.example.healthcare.Service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
    @RestController
    @RequestMapping("/api/medecins")
    public class MedecinController {
        final private MedecinService medecinService;

        @PostMapping()
        public void AjouterMedecin(@RequestBody MedecinDTO medecinDTO){
            medecinService.AjouterMedecin(medecinDTO);
        }
        @PutMapping("/{id}")
        public void ModifierMedecin(@PathVariable Long id,@RequestBody MedecinDTO medecinDTO){
          medecinService.ModifierMedecin(id,medecinDTO);
        }
        @DeleteMapping("/{id}")
        public void SupprimerMedecin(@PathVariable Long id){
           medecinService.SupprimerMedecin(id);
        }
        @GetMapping
        public List<MedecinDTO> ListerMedecins(){
            return medecinService.ListerAll();
        }
    }


