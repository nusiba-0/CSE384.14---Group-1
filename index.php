CREATE DATABASE meowoof;
USE meowoof;

-- Areas Table
CREATE TABLE Areas (
    area_id INT AUTO_INCREMENT PRIMARY KEY,
    area_name VARCHAR(100),
    location_description TEXT
);

-- Food Table
CREATE TABLE Food (
    food_id INT AUTO_INCREMENT PRIMARY KEY,
    area_id INT,
    food_type VARCHAR(50),
    quantity INT,
    distribution_time VARCHAR(50),
    FOREIGN KEY (area_id) REFERENCES Areas(area_id)
);

