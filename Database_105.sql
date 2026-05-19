
USE meowwoof_simple;

CREATE TABLE IF NOT EXISTS volunteers (
    id         INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(100) NOT NULL,
    email      VARCHAR(150) NOT NULL UNIQUE,
    phone      VARCHAR(20),
    password   VARCHAR(255) NOT NULL,
    area_id    INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (area_id) REFERENCES areas(id) ON DELETE SET NULL
);


CREATE TABLE IF NOT EXISTS reviews (
    id           INT PRIMARY KEY AUTO_INCREMENT,
    volunteer_id INT NOT NULL,
    area_id      INT NOT NULL,
    rating       TINYINT CHECK (rating BETWEEN 1 AND 5),
    comment      TEXT,
    review_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (volunteer_id) REFERENCES volunteers(id) ON DELETE CASCADE,
    FOREIGN KEY (area_id)      REFERENCES areas(id)      ON DELETE CASCADE
);




ALTER TABLE volunteers
ADD COLUMN bio VARCHAR(300) DEFAULT NULL;


ALTER TABLE reviews
MODIFY COLUMN comment TEXT NOT NULL;


ALTER TABLE reviews
ADD CONSTRAINT unique_volunteer_area_review UNIQUE (volunteer_id, area_id);

ALTER TABLE volunteers
DROP COLUMN bio;

INSERT INTO volunteers (name, email, phone, password, area_id)
VALUES ('Tanvir Ahmed', 'tanvir@test.com', '+880 1766666666', 'pass123', 2);

UPDATE volunteers
SET phone = '+880 1799999999'
WHERE email = 'tanvir@test.com';

DELETE FROM volunteers
WHERE email = 'tanvir@test.com';

SELECT
    v.id,
    v.name          AS volunteer_name,
    v.phone,
    v.email,
    a.name          AS assigned_area,
    a.location
FROM volunteers v
LEFT JOIN areas a ON v.area_id = a.id
ORDER BY a.name;


SELECT
    vol.name        AS reviewer,
    a.name          AS area_reviewed,
    r.rating,
    r.comment,
    r.review_date
FROM reviews r
JOIN volunteers vol ON r.volunteer_id = vol.id
JOIN areas      a   ON r.area_id      = a.id
ORDER BY r.rating DESC;


SELECT
    v.name          AS volunteer_name,
    v.email,
    a.name          AS assigned_area
FROM volunteers v
LEFT JOIN food_distribution fd ON v.id = fd.volunteer_id
LEFT JOIN areas              a  ON v.area_id = a.id
WHERE fd.id IS NULL;


SELECT
    a.name                    AS area_name,
    COUNT(DISTINCT v.id)      AS total_volunteers,
    COUNT(r.id)               AS total_reviews,
    ROUND(AVG(r.rating), 1)   AS avg_rating
FROM areas a
LEFT JOIN volunteers v ON a.id = v.area_id
LEFT JOIN reviews    r ON a.id = r.area_id
GROUP BY a.id, a.name
ORDER BY avg_rating DESC;
