USE meowwoof_simple;

CREATE TABLE IF NOT EXISTS medicines (
    id            INT PRIMARY KEY AUTO_INCREMENT,
    animal_id     INT NOT NULL,
    vet_id        INT,
    medicine_name VARCHAR(100),
    given_date    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    notes         TEXT,
    FOREIGN KEY (animal_id) REFERENCES animals(id) ON DELETE CASCADE,
    FOREIGN KEY (vet_id)    REFERENCES vets(id)    ON DELETE SET NULL
);


CREATE TABLE IF NOT EXISTS vets (
    id             INT PRIMARY KEY AUTO_INCREMENT,
    name           VARCHAR(100) NOT NULL,
    email          VARCHAR(150) NOT NULL UNIQUE,
    phone          VARCHAR(20),
    password       VARCHAR(255) NOT NULL,
    specialization VARCHAR(100),
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);




ALTER TABLE vets
ADD COLUMN is_available BOOLEAN DEFAULT TRUE;


ALTER TABLE medicines
MODIFY COLUMN medicine_name VARCHAR(200);


ALTER TABLE medicines
CHANGE notes treatment_notes TEXT;

INSERT INTO medicines (animal_id, vet_id, medicine_name, given_date, treatment_notes)
VALUES (1, 2, 'Rabies Vaccine', NOW(), 'Annual rabies vaccination');



UPDATE medicines
SET treatment_notes = 'Follow-up complete — animal fully recovered'
WHERE animal_id = 2 AND medicine_name = 'Amoxicillin';


UPDATE vets
SET is_available = FALSE
WHERE name = 'Dr. Prince Khan';



DELETE FROM medicines
WHERE medicine_name = 'Cough Syrup' AND animal_id = 2;



SELECT
    a.name          AS animal_name,
    a.type,
    a.health_status,
    v.name          AS vet_name,
    v.specialization,
    m.medicine_name,
    m.given_date,
    m.treatment_notes
FROM medicines m
JOIN animals a ON m.animal_id = a.id
JOIN vets    v ON m.vet_id    = v.id
WHERE v.name = 'Dr. Nazmul Hassan'
ORDER BY m.given_date DESC;


SELECT
    v.name            AS vet_name,
    v.specialization,
    COUNT(m.id)       AS total_treatments
FROM vets v
LEFT JOIN medicines m ON v.id = m.vet_id
GROUP BY v.id, v.name, v.specialization
ORDER BY total_treatments DESC;

SELECT
    name,
    specialization,
    phone
FROM vets
WHERE is_available = TRUE
ORDER BY specialization;

SELECT
    a.name          AS animal_name,
    a.type,
    a.health_status,
    COUNT(m.id)     AS treatment_count
FROM animals  a
JOIN medicines m ON a.id = m.animal_id
GROUP BY a.id, a.name, a.type, a.health_status
HAVING COUNT(m.id) > 1
ORDER BY treatment_count DESC;

