package org.example.meowwoof.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "vets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vet {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String name;
   @Column(unique = true)
   private String email;
   private String phone;
   private String password;
   private String specialization;
   private Boolean isAvailable;
}
