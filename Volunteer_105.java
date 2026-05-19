package org.example.meowwoof.model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "volunteers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Volunteer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String name;
   @Column(unique = true)
   private String email;
   private String phone;
   private String password;
   @ManyToOne
   @JoinColumn(name = "area_id")
   private Area area;
}
