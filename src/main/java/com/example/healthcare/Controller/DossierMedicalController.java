package com.example.healthcare.Controller;


import com.example.healthcare.DTO.DossierMedicalDTO;
import com.example.healthcare.Service.DossierMedicalService;
import com.example.healthcare.Service.RendezVousService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;




import java.util.List;
    @AllArgsConstructor
    @RestController
    @RequestMapping("/api/rendezVous")
    public class DossierMedicalController {
        final private DossierMedicalService dossierMedicalService;
        @PostMapping
        public void CreeDossier(@RequestBody DossierMedicalDTO dossierMedicalDTO){
            dossierMedicalService.CreeDossierMedical   (dossierMedicalDTO);
        }


    }


}
