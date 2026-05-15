package org.example.meowwoof.controller;


import lombok.RequiredArgsConstructor;
import org.example.meowwoof.model.Vet;
import org.example.meowwoof.service.VetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/vets")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class VetController {


   private final VetService vetService;


   @GetMapping
   public List<Vet> getAll() {
       return vetService.getAll();
   }


   @PostMapping("/register")
   public ResponseEntity<?> register(@RequestBody Vet vet) {
       try {
           Vet saved = vetService.register(vet);
           saved.setPassword(null);
           return ResponseEntity.ok(saved);
       } catch (RuntimeException e) {
           return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
       }
   }


   @PostMapping("/login")
   public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
       try {
           Vet vet = vetService.login(credentials);
           return ResponseEntity.ok(vet);
       } catch (RuntimeException e) {
           return ResponseEntity.status(401).body(Map.of("error", e.getMessage()));
       }
   }


   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Integer id) {
       vetService.delete(id);
       return ResponseEntity.noContent().build();
   }
}
