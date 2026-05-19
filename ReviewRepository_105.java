package org.example.meowwoof.repository;
import org.example.meowwoof.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
   List<Review> findByAreaId(Integer areaId);
   List<Review> findByVolunteerId(Integer volunteerId);
}

