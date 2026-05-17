package org.example.meowwoof.repository;


import org.example.meowwoof.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
   List<Medicine> findByAnimalId(Integer animalId);
   List<Medicine> findByVetId(Integer vetId);
}
