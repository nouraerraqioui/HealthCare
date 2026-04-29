
CREATE TABLE patient(
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(50) NOT NULL,
                        prenom VARCHAR(50) NOT NULL,
                        email VARCHAR(20) NOT NULL UNIQUE,
                        telephone VARCHAR(20) NOT NULL,
                        date_naissance DATE NOT NULL
);

CREATE TABLE medecin(
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(50) NOT NULL,
                        specialite VARCHAR(50) NOT NULL,
                        email VARCHAR(50) NOT NULL UNIQUE,
                        telephone VARCHAR(30) NOT NULL
);

CREATE TABLE rendez_vous(
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            date_rendez_vous DATETIME NOT NULL,
                            statut VARCHAR(20) NOT NULL,

                            medecin_id BIGINT,
                            patient_id BIGINT,

                            FOREIGN KEY (medecin_id) REFERENCES medecin(id),
                            FOREIGN KEY (patient_id) REFERENCES patient(id)
);
CREATE TABLE dossier_medical(
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                diagnostic VARCHAR(255) NOT NULL,
                                observations VARCHAR(255) NOT NULL,
                                date_creation DATETIME NOT NULL,
                                patient_id BIGINT,
                                CONSTRAINT fk_dossier_patient FOREIGN KEY (patient_id) REFERENCES patient(id)
);
