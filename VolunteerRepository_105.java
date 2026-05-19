package org.example.meowwoof.repository;
import org.example.meowwoof.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface VolunteerRepository extends JpaRepository<Volunteer, Integer> {
   Optional<Volunteer> findByEmail(String email);
   boolean existsByEmail(String email);
}

