package org.example.meowwoof.controller;
import org.example.meowwoof.model.Review;
import org.example.meowwoof.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {


   @Autowired
   private ReviewService reviewService;


   @GetMapping
   public List<Review> getAllReviews() {
       return reviewService.getAllReviews();
   }


   @GetMapping("/area/{areaId}")
   public List<Review> getReviewsByArea(@PathVariable Integer areaId) {
       return reviewService.getReviewsByArea(areaId);
   }


   @GetMapping("/volunteer/{volunteerId}")
   public List<Review> getReviewsByVolunteer(@PathVariable Integer volunteerId) {
       return reviewService.getReviewsByVolunteer(volunteerId);
   }


   @PostMapping
   public Review createReview(@RequestBody Review review) {
       return reviewService.createReview(review);
   }


   @DeleteMapping("/{id}")
   public void deleteReview(@PathVariable Integer id) {
       reviewService.deleteReview(id);
   }
}

