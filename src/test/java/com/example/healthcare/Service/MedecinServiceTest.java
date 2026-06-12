package com.example.healthcare.Service;

import com.example.healthcare.DTO.MedecinDTO;
import com.example.healthcare.Mapper.MedecinMapper;
import com.example.healthcare.Repository.MedecinRepository;
import com.example.healthcare.model.Medecin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MedecinServiceTest {

    @Mock
    private MedecinRepository medecinRepository;

    @Mock
    private MedecinMapper medecinMapper;

    @InjectMocks
    private MedecinService medecinService;

    @Test
    void ajouterMedecin() {


        MedecinDTO medecinDTO = new MedecinDTO();
        medecinDTO.setNom("reem");
        medecinDTO.setEmail("reem@email.com");
        medecinDTO.setSpecialite("dentiste");
        medecinDTO.setTelephone("0699987654");


        Medecin medecinEntity = new Medecin();
        medecinEntity.setNom("reem");
        medecinEntity.setEmail("reem@email.com");


        MedecinDTO savedDTO = new MedecinDTO();
        savedDTO.setNom("reem");
        savedDTO.setEmail("reem@email.com");

        // MOCK BEHAVIOR
        when(medecinMapper.toEntity(medecinDTO)).thenReturn(medecinEntity);
        when(medecinRepository.save(medecinEntity)).thenReturn(medecinEntity);
        when(medecinMapper.toDTO(medecinEntity)).thenReturn(savedDTO);


        MedecinDTO result = medecinService.AjouterMedecin(medecinDTO);


        assertNotNull(result);
        assertEquals("reem", result.getNom());

        verify(medecinRepository, times(1)).save(medecinEntity);
    }
}