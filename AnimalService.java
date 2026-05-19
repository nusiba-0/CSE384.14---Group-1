package org.example.meowwoof.service;
import org.example.meowwoof.model.Animal;
import org.example.meowwoof.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AnimalService {


   @Autowired
   private AnimalRepository animalRepository;


   public List<Animal> getAllAnimals() {
       return animalRepository.findAll();
   }


   public Animal getAnimalById(Integer id) {
       return animalRepository.findById(id).orElse(null);
   }


   public List<Animal> getAnimalsByArea(Integer areaId) {
       return animalRepository.findByAreaId(areaId);
   }


   public List<Animal> getUnhealthyAnimals() {
       List<Animal> sick    = animalRepository.findByHealthStatus("sick");
       List<Animal> injured = animalRepository.findByHealthStatus("injured");
       sick.addAll(injured);
       return sick;
   }


   public Animal createAnimal(Animal animal) {
       return animalRepository.save(animal);
   }


   public Animal updateAnimal(Integer id, Animal details) {
       Animal animal = animalRepository.findById(id).orElse(null);
       if (animal != null) {
           animal.setName(details.getName());
           animal.setType(details.getType());
           animal.setHealthStatus(details.getHealthStatus());
           animal.setIsVaccinated(details.getIsVaccinated());
           animal.setAge(details.getAge());
           animal.setWeight(details.getWeight());
           animal.setArea(details.getArea());
           return animalRepository.save(animal);
       }
       return null;
   }


   public void deleteAnimal(Integer id) {
       animalRepository.deleteById(id);
   }
}
