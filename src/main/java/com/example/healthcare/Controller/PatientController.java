package com.example.healthcare.Controller;

import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.Service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/patients")
public class PatientController {
final private PatientService patientService;

@PostMapping()
    public PatientDTO AjouterPatient(@RequestBody PatientDTO patientDTO){
  return   patientService.AjouterPatient(patientDTO);
}
@PutMapping("/{id}")
    public PatientDTO ModifierPatient(@PathVariable Long id,@RequestBody PatientDTO patientDTO){
   return patientService.ModifierPatient(id,patientDTO);
}
@DeleteMapping("/{id}")
    public void SupprimerPatient(@PathVariable Long id){
    patientService.SupprimerPatient(id);
}
@GetMapping
@PreAuthorize("hasRole('ADMIN')")
    public List<PatientDTO> ListerPatients(Pageable pageable){
    return patientService.ListerPatients(pageable);
}
@GetMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')")
    public PatientDTO ConsulterPatient(@PathVariable Long id,Pageable pageable){
    return patientService.ConsulterPatient(id,pageable);
}

}
