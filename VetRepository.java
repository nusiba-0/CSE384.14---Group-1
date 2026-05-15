package org.example.meowwoof.repository;


import org.example.meowwoof.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface VetRepository extends JpaRepository<Vet, Integer> {
   Optional<Vet> findByEmail(String email);
   boolean existsByEmail(String email);
}
