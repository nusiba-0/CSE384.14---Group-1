package org.example.meowwoof.service;
import org.example.meowwoof.model.Review;
import org.example.meowwoof.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ReviewService {
 @Autowired
   private ReviewRepository reviewRepository;


   public List<Review> getAllReviews() {
       return reviewRepository.findAll();
   }


   public List<Review> getReviewsByArea(Integer areaId) {
       return reviewRepository.findByAreaId(areaId);
   }


   public List<Review> getReviewsByVolunteer(Integer volunteerId) {
       return reviewRepository.findByVolunteerId(volunteerId);
   }


   public Review createReview(Review review) {
       return reviewRepository.save(review);
   }


   public void deleteReview(Integer id) {
       reviewRepository.deleteById(id);
   }
}
