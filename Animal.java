package org.example.meowwoof.model;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;


@Entity
@Table(name = "animals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;


   private String name;
   private String type;
   private String healthStatus;
   private Boolean isVaccinated;
   private Integer age;
   private BigDecimal weight;


   @ManyToOne
   @JoinColumn(name = "area_id")
   private Area area;
}
