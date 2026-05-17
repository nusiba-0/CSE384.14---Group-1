
package org.example.meowwoof.service;


import org.example.meowwoof.model.Medicine;
import org.example.meowwoof.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MedicineService {


   @Autowired
   private MedicineRepository medicineRepository;


   public List<Medicine> getAllMedicines() {
       return medicineRepository.findAll();
   }


   public List<Medicine> getMedicineByAnimal(Integer animalId) {
       return medicineRepository.findByAnimalId(animalId);
   }


   public List<Medicine> getMedicineByVet(Integer vetId) {
       return medicineRepository.findByVetId(vetId);
   }


   public Medicine createMedicine(Medicine medicine) {
       return medicineRepository.save(medicine);
   }


   public void deleteMedicine(Integer id) {
       medicineRepository.deleteById(id);
   }
}
