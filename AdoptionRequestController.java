package org.example.meowwoof.controller;
import org.example.meowwoof.model.AdoptionRequest;
import org.example.meowwoof.service.AdoptionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/adoptions")
@CrossOrigin(origins = "*")
public class AdoptionRequestController {


   @Autowired
   private AdoptionRequestService adoptionRequestService;


   @GetMapping
   public List<AdoptionRequest> getAllRequests() {
       return adoptionRequestService.getAllRequests();
   }


   @GetMapping("/pending")
   public List<AdoptionRequest> getPendingRequests() {
       return adoptionRequestService.getPendingRequests();
   }


   @GetMapping("/volunteer/{volunteerId}")
   public List<AdoptionRequest> getRequestsByVolunteer(@PathVariable Integer volunteerId) {
       return adoptionRequestService.getRequestsByVolunteer(volunteerId);
   }


   @PostMapping
   public AdoptionRequest createRequest(@RequestBody AdoptionRequest request) {
       return adoptionRequestService.createRequest(request);
   }


   @PutMapping("/{id}/status")
   public AdoptionRequest updateStatus(@PathVariable Integer id, @RequestParam String status) {
       return adoptionRequestService.updateStatus(id, status);
   }


   @DeleteMapping("/{id}")
   public void deleteRequest(@PathVariable Integer id) {
       adoptionRequestService.deleteRequest(id);
   }
}
