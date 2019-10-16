package net.tirgan.graphql.repository;

import net.tirgan.graphql.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
