package org.example.meowwoof.service;


import lombok.RequiredArgsConstructor;
import org.example.meowwoof.model.Vet;
import org.example.meowwoof.repository.VetRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class VetService {


   private final VetRepository vetRepository;


   public List<Vet> getAll() {
       return vetRepository.findAll();
   }


   public Vet register(Vet vet) {
       if (vetRepository.existsByEmail(vet.getEmail())) {
           throw new RuntimeException("Email already registered");
       }
       return vetRepository.save(vet);
   }


   public Vet login(Map<String, String> credentials) {
       String email    = credentials.get("email");
       String password = credentials.get("password");
       Vet vet = vetRepository.findByEmail(email)
               .orElseThrow(() -> new RuntimeException("Invalid email or password"));
       if (!vet.getPassword().equals(password)) {
           throw new RuntimeException("Invalid email or password");
       }
       vet.setPassword(null);
       return vet;
   }


   public void delete(Integer id) {
       vetRepository.deleteById(id);
   }
}
