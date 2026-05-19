package org.example.meowwoof.service;


import org.example.meowwoof.model.AdoptionRequest;
import org.example.meowwoof.repository.AdoptionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AdoptionRequestService {


   @Autowired
   private AdoptionRequestRepository adoptionRequestRepository;


   public List<AdoptionRequest> getAllRequests() {
       return adoptionRequestRepository.findAll();
   }


   public List<AdoptionRequest> getPendingRequests() {
       return adoptionRequestRepository.findByStatus("pending");
   }


   public List<AdoptionRequest> getRequestsByVolunteer(Integer volunteerId) {
       return adoptionRequestRepository.findByVolunteerId(volunteerId);
   }


   public AdoptionRequest createRequest(AdoptionRequest request) {
       return adoptionRequestRepository.save(request);
   }


   public AdoptionRequest updateStatus(Integer id, String status) {
       AdoptionRequest request = adoptionRequestRepository.findById(id).orElse(null);
       if (request != null) {
           request.setStatus(status);
           return adoptionRequestRepository.save(request);
       }
       return null;
   }


   public void deleteRequest(Integer id) {
       adoptionRequestRepository.deleteById(id);
   }
}
