package org.example.meowwoof.controller;


import lombok.RequiredArgsConstructor;
import org.example.meowwoof.model.Volunteer;
import org.example.meowwoof.service.VolunteerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/volunteers")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class VolunteerController {


   private final VolunteerService volunteerService;


   @GetMapping
   public List<Volunteer> getAll() {
       return volunteerService.getAll();
   }


   @PostMapping("/register")
   public ResponseEntity<?> register(@RequestBody Volunteer volunteer) {
       try {
           Volunteer saved = volunteerService.register(volunteer);
           saved.setPassword(null); // never send password back
           return ResponseEntity.ok(saved);
       } catch (RuntimeException e) {
           return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
       }
   }
   @PostMapping("/login")
   public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
       try {
           Volunteer volunteer = volunteerService.login(credentials);
           return ResponseEntity.ok(volunteer);
       } catch (RuntimeException e) {
           return ResponseEntity.status(401).body(Map.of("error", e.getMessage()));
       }
   }


   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Integer id) {
       volunteerService.delete(id);
       return ResponseEntity.noContent().build();
   }
}


