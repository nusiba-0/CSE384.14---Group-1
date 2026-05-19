package org.example.meowwoof.repository;


import org.example.meowwoof.model.AdoptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest, Integer> {
   List<AdoptionRequest> findByStatus(String status);
   List<AdoptionRequest> findByVolunteerId(Integer volunteerId);
   List<AdoptionRequest> findByAnimalId(Integer animalId);
}
