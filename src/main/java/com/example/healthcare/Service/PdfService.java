package com.example.healthcare.Service;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.example.healthcare.Repository.DossierMedicalRepository;
import com.example.healthcare.Repository.PatientRepository;
import com.example.healthcare.Repository.RendezVousRepository;
import com.example.healthcare.model.DossierMedical;
import com.example.healthcare.model.Patient;
import com.example.healthcare.model.RendezVous;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PdfService {

    private final DossierMedicalRepository dossierRepo;
    private final RendezVousRepository rendezVousRepo;
    private final PatientRepository patientRepo;

    public byte[] exportDossier(Long dossierId) throws Exception {
        DossierMedical d = dossierRepo.findById(dossierId)
                .orElseThrow(() -> new RuntimeException("Dossier introuvable"));

        Document doc = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(doc, out);
        doc.open();

        doc.add(new Paragraph("Dossier Médical"));
        doc.add(new Paragraph("Patient: " + d.getPatient().getNom()));
        doc.add(new Paragraph("Diagnostic: " + d.getDiagnostic()));
        doc.add(new Paragraph("Observations: " + d.getObservations()));
        doc.add(new Paragraph("Date: " + d.getDateCreation()));

        doc.close();
        return out.toByteArray();
    }

    public byte[] exportRendezVous(Long patientId) throws Exception {
        Patient p = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient introuvable"));
        List<RendezVous> liste = rendezVousRepo.findByPatientId(patientId);

        Document doc = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(doc, out);
        doc.open();

        doc.add(new Paragraph("Rendez-vous de: " + p.getNom()));
        doc.add(new Paragraph(" "));
        for (RendezVous rv : liste) {
            doc.add(new Paragraph("- " + rv.getDateRendezVous() + " | " + rv.getStatut()));
        }

        doc.close();
        return out.toByteArray();
    }

    public byte[] exportRapport() throws Exception {
        Document doc = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(doc, out);
        doc.open();

        doc.add(new Paragraph("Rapport Global"));
        doc.add(new Paragraph("Total patients: " + patientRepo.count()));
        doc.add(new Paragraph("Total rendez-vous: " + rendezVousRepo.count()));
        doc.add(new Paragraph("Total dossiers: " + dossierRepo.count()));

        doc.close();
        return out.toByteArray();
    }
}