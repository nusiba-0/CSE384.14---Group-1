package org.example.meowwoof.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private Integer rating;
   private String comment;
   private LocalDateTime reviewDate;
   @ManyToOne
   @JoinColumn(name = "volunteer_id")
   private Volunteer volunteer;
   @ManyToOne
   @JoinColumn(name = "area_id")
   private Area area;
}
