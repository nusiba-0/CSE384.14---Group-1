package org.example.meowwoof.model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "medicines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;


   private String medicineName;
   private LocalDateTime givenDate;


   @Column(name = "treatment_notes")
   private String treatmentNotes;


   @ManyToOne
   @JoinColumn(name = "animal_id")
   private Animal animal;


   @ManyToOne
   @JoinColumn(name = "vet_id")
   private Vet vet;
}
