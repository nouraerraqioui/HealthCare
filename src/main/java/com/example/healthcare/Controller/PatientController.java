package com.example.healthcare.Controller;

import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.Service.PatientService;
import com.example.healthcare.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;




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
    public Page<Patient> ListerPatients(  @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "5") int size,
                                          @RequestParam(defaultValue = "nom") String sortBy) {

    return patientService.ListerPatients(page, size, sortBy);

}

@GetMapping("/recherche")
@PreAuthorize("hasRole('ADMIN')")
    public Page<Patient> ConsulterPatient(
        @RequestParam String nom,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "nom") String sortBy) {

    return patientService.ConsulterPatient(nom, page, size, sortBy);
}
}
