package org.example.meowwoof.model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "adoption_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdoptionRequest {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;


   private String status;
   private LocalDateTime requestDate;


   @ManyToOne
   @JoinColumn(name = "animal_id")
   private Animal animal;


   @ManyToOne
   @JoinColumn(name = "volunteer_id")
   private Volunteer volunteer;
}
