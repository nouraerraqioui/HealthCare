package com.example.healthcare.Service;

import com.example.healthcare.DTO.MedecinDTO;
import com.example.healthcare.Mapper.MedecinMapper;
import com.example.healthcare.Repository.MedecinRepository;
import com.example.healthcare.model.Medecin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class MedecinServiceTest {
    @Autowired
    private MedecinService medecinService;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private MedecinMapper medecinMapper;


    @Test
    void ajouterMedecin() {
        MedecinDTO medecinDTO=new MedecinDTO();
        medecinDTO.setNom("reem");
        medecinDTO.setEmail("reem@email.com");
        medecinDTO.setSpecialite("dentiste");
        medecinDTO.setTelephone("0699987654");


         MedecinDTO result = medecinService.AjouterMedecin(medecinDTO);
         assertNotNull(result);


    }


}