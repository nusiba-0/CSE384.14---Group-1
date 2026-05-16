package org.example.meowwoof.controller;


import org.example.meowwoof.model.Medicine;
import org.example.meowwoof.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/medicines")
@CrossOrigin(origins = "*")
public class MedicineController {


   @Autowired
   private MedicineService medicineService;


   @GetMapping
   public List<Medicine> getAllMedicines() {
       return medicineService.getAllMedicines();
   }


   @GetMapping("/animal/{animalId}")
   public List<Medicine> getMedicineByAnimal(@PathVariable Integer animalId) {
       return medicineService.getMedicineByAnimal(animalId);
   }


   @GetMapping("/vet/{vetId}")
   public List<Medicine> getMedicineByVet(@PathVariable Integer vetId) {
       return medicineService.getMedicineByVet(vetId);
   }


   @PostMapping
   public Medicine createMedicine(@RequestBody Medicine medicine) {
       return medicineService.createMedicine(medicine);
   }


   @DeleteMapping("/{id}")
   public void deleteMedicine(@PathVariable Integer id) {
       medicineService.deleteMedicine(id);
   }
}
