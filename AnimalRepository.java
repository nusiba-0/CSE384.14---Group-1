package org.example.meowwoof.repository;


import org.example.meowwoof.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
   List<Animal> findByAreaId(Integer areaId);
   List<Animal> findByHealthStatus(String healthStatus);
   List<Animal> findByIsVaccinated(Boolean isVaccinated);
   List<Animal> findByType(String type);
}

