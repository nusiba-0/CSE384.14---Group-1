USE meowoof_db;


CREATE TABLE Volunteers (

    volunteer_id INT AUTO_INCREMENT PRIMARY KEY,

    user_id INT NOT NULL,

    assigned_area VARCHAR(100) NOT NULL,

    schedule VARCHAR(100) NOT NULL,

    availability_status VARCHAR(50) NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);



CREATE TABLE Reviews (

    review_id INT AUTO_INCREMENT PRIMARY KEY,

    user_id INT NOT NULL,

    rating INT NOT NULL,

    comment TEXT NOT NULL,

    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);
