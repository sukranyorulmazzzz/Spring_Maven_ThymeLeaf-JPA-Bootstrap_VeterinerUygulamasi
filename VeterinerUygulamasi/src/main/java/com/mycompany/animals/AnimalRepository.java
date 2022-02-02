package com.mycompany.animals;

import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal,Integer> {
    public Long countById(Integer id);
}
