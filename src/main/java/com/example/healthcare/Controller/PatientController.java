package com.example.healthcare.Controller;

import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.Service.PatientService;
import com.example.healthcare.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;


@AllArgsConstructor
@RestController
@RequestMapping("/api/patients")
public class PatientController {
final private PatientService patientService;

@PostMapping()
@PreAuthorize("hasRole('ADMIN')")
    public PatientDTO AjouterPatient(@RequestBody PatientDTO patientDTO){
  return   patientService.AjouterPatient(patientDTO);
}
@PutMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")

    public PatientDTO ModifierPatient(@PathVariable Long id,@RequestBody PatientDTO patientDTO){
   return patientService.ModifierPatient(id,patientDTO);
}
@DeleteMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
    public void SupprimerPatient(@PathVariable Long id){
    patientService.SupprimerPatient(id);
}
@GetMapping
@PreAuthorize("hasAnyRole('ADMIN','MEDECIN')")
    public Page<Patient> ListerPatients(Pageable pageable){
    return patientService.ListerPatients(pageable);
}
@GetMapping("/{nom}")
@PreAuthorize("hasRole('ADMIN')")
    public Page<Patient> ConsulterPatient(@PathVariable String nom,Pageable pageable){
    return patientService.ConsulterPatient(nom,pageable);
}

}
