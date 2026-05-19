package org.example.meowwoof.service;
import lombok.RequiredArgsConstructor;
import org.example.meowwoof.model.Volunteer;
import org.example.meowwoof.repository.VolunteerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class VolunteerService {


   private final VolunteerRepository volunteerRepository;


   public List<Volunteer> getAll() {
       return volunteerRepository.findAll();
   }


   public Volunteer register(Volunteer volunteer) {
       if (volunteerRepository.existsByEmail(volunteer.getEmail())) {
           throw new RuntimeException("Email already registered");
       }
       return volunteerRepository.save(volunteer);
   }


   public Volunteer login(Map<String, String> credentials) {
       String email    = credentials.get("email");
       String password = credentials.get("password");
       Volunteer volunteer = volunteerRepository.findByEmail(email)
               .orElseThrow(() -> new RuntimeException("Invalid email or password"));
       if (!volunteer.getPassword().equals(password)) {
           throw new RuntimeException("Invalid email or password");
       }
       volunteer.setPassword(null);
       return volunteer;
   }
    public void delete(Integer id) {
       volunteerRepository.deleteById(id);
   }
}


