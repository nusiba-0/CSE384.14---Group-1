SELECT 
    Areas.area_name,
    Food.food_type,
    Food.quantity,
    Food.distribution_time
FROM Food
JOIN Areas ON Food.area_id = Areas.area_id;
