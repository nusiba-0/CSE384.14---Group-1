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


-- Sample Volunteers
INSERT INTO Volunteers (user_id, assigned_area, schedule, availability_status) VALUES
(1, 1, 'Saturday & Sunday, 8AM-11AM',  'available'),
(2, 2, 'Friday, 9AM-12PM',             'available'),
(3, 3, 'Monday & Wednesday, 7AM-10AM', 'available'),
(4, 3, 'Tuesday & Thursday, 5PM-7PM',  'unavailable'),
(5, 4, 'Sunday, 10AM-1PM',             'on_leave');

-- Sample Reviews
INSERT INTO Reviews (user_id, rating, comment, review_date) VALUES
(1, 5, 'Amazing platform! Really helps coordinate feeding schedules.',  '2024-06-01'),
(2, 4, 'Very useful. Would love a mobile app version.',                 '2024-06-05'),
(3, 5, 'As a donor I can now see exactly where my contributions go.',   '2024-06-10'),
(4, 3, 'Good system but needs more volunteers in Mohakhali area.',      '2024-06-12'),
(5, 4, 'Easy to use. The area map feature is very helpful.',            '2024-06-15');



-- Q1: Show all volunteers with their availability status
SELECT volunteer_id, user_id, assigned_area, schedule, availability_status
FROM Volunteers;

-- Q2: Show only available volunteers
SELECT volunteer_id, user_id, assigned_area, schedule
FROM Volunteers
WHERE availability_status = 'available';

-- Q3: Count volunteers assigned to each area
SELECT assigned_area, COUNT(*) AS volunteer_count
FROM Volunteers
GROUP BY assigned_area;

-- Q4: Show all reviews sorted by rating (highest first)
SELECT review_id, user_id, rating, comment, review_date
FROM Reviews
ORDER BY rating DESC;

-- Q5: Calculate the average rating
SELECT ROUND(AVG(rating), 2) AS average_rating
FROM Reviews;

-- Q6: Show only 5-star reviews
SELECT user_id, comment, review_date
FROM Reviews
WHERE rating = 5;
