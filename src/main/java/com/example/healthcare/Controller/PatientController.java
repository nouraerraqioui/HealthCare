package com.example.healthcare.Controller;

import com.example.healthcare.DTO.PatientDTO;
import com.example.healthcare.Service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public List<PatientDTO> ListerPatients(){
    return patientService.ListerPatients();
}
@GetMapping("/{id}")
    public PatientDTO ConsulterPatient(@PathVariable Long id){
    return patientService.ConsulterPatient(id);
}

}
