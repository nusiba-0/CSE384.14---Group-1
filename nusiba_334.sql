USE meowwoof_simple;


CREATE TABLE IF NOT EXISTS animals (
    id            INT PRIMARY KEY AUTO_INCREMENT,
    name          VARCHAR(100) NOT NULL,
    type          ENUM('dog','cat') NOT NULL,
    area_id       INT,
    health_status ENUM('healthy','sick','injured') DEFAULT 'healthy',
    is_vaccinated BOOLEAN DEFAULT FALSE,
    age           INT,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (area_id) REFERENCES areas(id) ON DELETE SET NULL
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

ALTER TABLE vets
ADD COLUMN is_available BOOLEAN DEFAULT TRUE;


ALTER TABLE animals
ADD COLUMN weight DECIMAL(5,2) DEFAULT NULL;


ALTER TABLE animals
ADD INDEX idx_health_status (health_status);


ALTER TABLE animals
DROP INDEX idx_health_status;


INSERT INTO vets (name, email, phone, password, specialization, is_available)
VALUES ('Dr. Ayasha Siddiqua', 'ayasha@vet.com', '+880 1855555555', 'vet123', 'Internal Medicine', TRUE);


UPDATE vets
SET specialization = 'Emergency Care'
WHERE email = 'ayasha@vet.com';


DELETE FROM vets
WHERE email = 'ayasha@vet.com';


SELECT
    a.name          AS animal_name,
    a.type,
    a.health_status,
    CASE WHEN a.is_vaccinated THEN 'Yes' ELSE 'No' END AS vaccinated,
    ar.name         AS area,
    v.name          AS treating_vet,
    m.medicine_name,
    m.given_date
FROM animals   a
LEFT JOIN areas     ar ON a.area_id  = ar.id
LEFT JOIN medicines m  ON a.id       = m.animal_id
LEFT JOIN vets      v  ON m.vet_id   = v.id
ORDER BY a.name, m.given_date DESC;


SELECT
    a.name          AS animal_name,
    a.type,
    a.health_status,
    ar.name         AS area
FROM animals   a
LEFT JOIN areas     ar ON a.area_id = ar.id
LEFT JOIN medicines m  ON a.id      = m.animal_id
WHERE a.health_status IN ('sick','injured')
  AND m.id IS NULL;


SELECT
    a.name          AS animal,
    a.health_status,
    m.medicine_name AS latest_medicine,
    m.given_date,
    v.name          AS vet
FROM animals a
LEFT JOIN medicines m ON a.id = m.animal_id
LEFT JOIN vets      v ON m.vet_id = v.id
WHERE m.given_date = (
    SELECT MAX(m2.given_date)
    FROM medicines m2
    WHERE m2.animal_id = a.id
)
ORDER BY a.name;


SELECT
    ar.name                                                        AS area,
    COUNT(a.id)                                                    AS total_animals,
    SUM(a.is_vaccinated)                                           AS vaccinated,
    COUNT(a.id) - SUM(a.is_vaccinated)                             AS not_vaccinated,
    CONCAT(ROUND(SUM(a.is_vaccinated) / COUNT(a.id) * 100), '%')   AS coverage_pct
FROM areas   ar
LEFT JOIN animals a ON ar.id = a.area_id
GROUP BY ar.id, ar.name
ORDER BY coverage_pct DESC;

