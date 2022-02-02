package com.mycompany;

import com.mycompany.animals.Animal;
import com.mycompany.animals.AnimalRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class AnimalRepositoryTest {
    @Autowired private AnimalRepository repo;
    @Test
    public void testAddNew(){
        Animal animal=new Animal();
        animal.setTur("Kopek");
        animal.setCins("Golden Retriever");
        animal.setIsim("Poncik");
        animal.setAciklama("Golden Retriever, köpek ırkı.");
        animal.setYas(3);
        animal.setSahipAd("Şükran");

        Animal savedAnimal=repo.save(animal);
        Assertions.assertThat(savedAnimal).isNotNull();
        Assertions.assertThat(savedAnimal.getId()).isGreaterThan(0);

       }
       @Test
    public void testListAll(){
           Iterable<Animal> animals = repo.findAll();
           Assertions.assertThat(animals).hasSizeGreaterThan(0);
           for (Animal animal:animals){
               System.out.println(animal);
           }
       }
       @Test
    public void testUpdate(){
        Integer userId=1;
        Optional<Animal>optionalAnimal= repo.findById(userId);
        Animal animal=optionalAnimal.get();
        animal.setSahipAd("Yorulmaz");
        repo.save(animal);

        Animal updatedAnimal=repo.findById(userId).get();
        Assertions.assertThat(updatedAnimal.getSahipAd()).isEqualTo("Yorulmaz");
       }
       @Test
    public void testGet(){
        Integer userId=2;
        Optional<Animal> optionalAnimal=repo.findById(userId);
        Assertions.assertThat(optionalAnimal).isPresent();
           System.out.println(optionalAnimal.get());
       }
       @Test
    public void testDelete(){
        Integer userId=3;
        repo.deleteById(userId);
           Optional<Animal> optionalAnimal=repo.findById(userId);
           Assertions.assertThat(optionalAnimal).isNotPresent();
       }
}
